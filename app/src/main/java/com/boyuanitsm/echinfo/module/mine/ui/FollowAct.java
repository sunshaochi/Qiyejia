package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.module.company.ui.CompanyAct;
import com.boyuanitsm.echinfo.module.mine.presenter.IFollowPre;
import com.boyuanitsm.echinfo.module.mine.presenter.IFollowPreImpl;
import com.boyuanitsm.echinfo.module.mine.view.IFollowView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的关注
 * Created by Yang on 2016/12/30 0030.
 */
public class FollowAct extends BaseAct<IFollowPre> implements IFollowView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<AttenBean> myAdapter;//我的关注适配器
    private List<AttenBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_follow;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("我的关注");
        mPresenter=new IFollowPreImpl(this);
        mPresenter.getFollowDatas();
//        testList = EchinfoUtils.getTestDatas(4);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        myAdapter = new BaseRecyclerAdapter<AttenBean>(getApplicationContext(),datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_item_follow;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, AttenBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_fr).setText("公司法人:"+item.getLegalPerson());
                holder.getTextView(R.id.tv_zt).setText(item.getManagementStatus());

            }
        };
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getFollowDatas();
            }

            @Override
            public void onLoadMore() {

            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID,datas.get(position).getId());
                openActivity(CompanyAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(myAdapter);
    }



    @Override
    public void setFollowDatas(List<AttenBean> mdatas) {
        rcv.refreshComplete();
        datas=mdatas;
        myAdapter.setData(datas);

    }

    @Override
    public void requestError(int status, String errorMsg) {
        rcv.refreshComplete();
        toast(errorMsg);

    }

    @Override
    public void requestNoData() {
        rcv.refreshComplete();

    }
}
