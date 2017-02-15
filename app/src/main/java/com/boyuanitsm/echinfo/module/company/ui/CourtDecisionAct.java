package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CourtDecisionBean;
import com.boyuanitsm.echinfo.module.company.presenter.CourdecPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 法院判决
 * Created by Yang on 2017/1/3 0003.
 */
public class CourtDecisionAct extends BaseAct<ICompanyBasePre> implements IBaseListView<CourtDecisionBean> {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<CourtDecisionBean> mAdp;
    private List<CourtDecisionBean> datas = new ArrayList<>();
    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("法院判决");
        mPresenter = new CourdecPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, this, false);
        mAdp = new BaseRecyclerAdapter<CourtDecisionBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_courtdecision_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CourtDecisionBean item) {
                holder.getTextView(R.id.tvName).setText(item.getTitle());
                holder.getTextView(R.id.tvNo).setText("编号：" + item.getCaseNo());
                holder.getTextView(R.id.tvDate).setText(item.getDate());
            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDatas(companyId);

            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void setDatas(List<CourtDecisionBean> mDatas) {
        rcv.refreshComplete();
        datas=mDatas;
        mAdp.setData(datas);
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
