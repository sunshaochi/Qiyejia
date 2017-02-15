package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.AdministrativePenaltyBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.PunishmentPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 行政处罚
 * Created by Yang on 2017/1/4 0004.
 */
public class PunishmentAct extends BaseAct<ICompanyBasePre> implements IBaseListView<AdministrativePenaltyBean> {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<AdministrativePenaltyBean> mAdp;
    private List<AdministrativePenaltyBean> datas = new ArrayList<>();
    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("行政处罚");
        mPresenter = new PunishmentPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<AdministrativePenaltyBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_punishment_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, AdministrativePenaltyBean item) {
                holder.getTextView(R.id.tvWh).setText("文号：" + item.getReferenceNumber());
                holder.getTextView(R.id.tvType).setText(item.getType());
                holder.getTextView(R.id.tvJg).setText(item.getDecisionOrgan());
                holder.getTextView(R.id.tvDate).setText(item.getDate());
                holder.getTextView(R.id.tvContent).setText(item.getContent());
            }
        };
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
    public void setDatas(List<AdministrativePenaltyBean> mDatas) {
        rcv.refreshComplete();
        datas = mDatas;
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
