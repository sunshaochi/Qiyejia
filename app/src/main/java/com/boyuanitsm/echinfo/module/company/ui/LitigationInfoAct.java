package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.LawsuitMsgBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.LawsuitMsgPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 诉讼信息
 * Created by Yang on 2017/1/5 0005.
 */
public class LitigationInfoAct extends BaseAct<ICompanyBasePre> implements IBaseListView<LawsuitMsgBean>{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<LawsuitMsgBean> mAdp;
    private List<LawsuitMsgBean> datas = new ArrayList<>();
    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("诉讼信息");
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter=new LawsuitMsgPreImpl(this);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<LawsuitMsgBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_litigationinfo_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, LawsuitMsgBean item) {
                holder.getTextView(R.id.tv_lgName).setText(item.getCourt());
                holder.getTextView(R.id.tv_lgNum).setText(item.getName());
                holder.getTextView(R.id.tv_lgTime).setText(item.getRegistrineTime());

            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putParcelable(LitigationDetailAct.LITIGATION_DETAIL,datas.get(position-1));
                openActivity(LitigationDetailAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
        rcv.setAdapter(mAdp);
    }


    @Override
    public void setDatas(List<LawsuitMsgBean> mDatas) {
        rcv.refreshComplete();
        datas=mDatas;
        mAdp.setData(datas);
    }


    @Override
    public void requestError(int status, String errorMsg) {
        rcv.refreshComplete();

    }

    @Override
    public void requestNoData() {
        rcv.refreshComplete();
    }
}
