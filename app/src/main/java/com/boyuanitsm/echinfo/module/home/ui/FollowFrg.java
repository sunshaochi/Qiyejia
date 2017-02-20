package com.boyuanitsm.echinfo.module.home.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.module.mine.presenter.IFollowPre;
import com.boyuanitsm.echinfo.module.mine.presenter.IFollowPreImpl;
import com.boyuanitsm.echinfo.module.mine.view.IFollowView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 关注
 * Created by wangbin on 16/12/22.
 */
public class FollowFrg extends BaseFrg<IFollowPre> implements IFollowView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<AttenBean> myAdapter;//我的关注适配器
    private List<AttenBean> datas = new ArrayList<>();
    @Override
    public int getLayout() {
        return R.layout.frg_follow;
    }

    @Override
    protected void initView(View fragmentRootView) {
        mPresenter=new IFollowPreImpl(this);
        mPresenter.getFollowDatas();
//        testList = EchinfoUtils.getTestDatas(4);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), true);
        myAdapter = new BaseRecyclerAdapter<AttenBean>(getContext(),datas) {
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
