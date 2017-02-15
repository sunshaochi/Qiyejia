package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.presenter.ForengnInvesPreImpl;
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
 * 对外投资
 * Created by Yang on 2017/1/3 0003.
 */
public class ForeignInvestmentAct extends BaseAct<ICompanyBasePre> implements IBaseListView<CompanyBean>{
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    private String companyId;

    private BaseRecyclerAdapter<CompanyBean> adapter;
    private List<CompanyBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_foreigninvestment;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("对外投资");
        mPresenter=new ForengnInvesPreImpl(this);
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getDatas(companyId);
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, this, false);
        adapter = new BaseRecyclerAdapter<CompanyBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_foreigninvestment_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tvCompanyName).setText(item.getCompanyName());
                holder.getTextView(R.id.tvStatus).setText(item.getManagementStatus());
                holder.getTextView(R.id.tvPerson).setText(item.getLegalPerson());
                holder.getTextView(R.id.tvRegMoney).setText(item.getCapital());
                holder.getTextView(R.id.tvClDate).setText(item.getEstablishDate());
                holder.getTextView(R.id.tvHy).setText(item.getIndustry());
                holder.getTextView(R.id.tvRegNo).setText(item.getRegistNo());
                holder.getTextView(R.id.tvWz).setText(item.getUrl());
                holder.getTextView(R.id.tvAddress).setText(item.getAddress());

            }
        };
        rcv.setAdapter(adapter);
        rcv.setRefreshing(true);
    }


    @Override
    public void setDatas(List<CompanyBean> mDatas) {
        rcv.refreshComplete();
        datas=mDatas;
        adapter.setData(datas);
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
