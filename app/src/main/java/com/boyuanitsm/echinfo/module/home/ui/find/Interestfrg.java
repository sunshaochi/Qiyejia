package com.boyuanitsm.echinfo.module.home.ui.find;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.ui.CompanyAct;
import com.boyuanitsm.echinfo.module.home.presenter.IInterestPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.InterestPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.IInterestView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 可能感兴趣
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class Interestfrg extends BaseFrg<IInterestPresenter> implements IInterestView,OnItemClickListener {
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    private BaseRecyclerAdapter<CompanyBean> myAdapter;//可能感兴趣适配器
    private List<CompanyBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.interestfrg_layout;
    }

    @Override
    protected void initView(View fragmentRootView) {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), false);
        mPresenter = new InterestPresenterImpl(this);
        initRcv();
        mPresenter.getCompanyList();
    }

    /**
     * 填充数据
     */
    private void initRcv() {
        myAdapter = new BaseRecyclerAdapter<CompanyBean>(getContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_interestfrg;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tvComName).setText(item.getCompanyName());
                holder.getTextView(R.id.tvStatus).setText(item.getManagementStatus());

                holder.getTextView(R.id.tvName).setText(item.getLegalPerson());
                holder.getTextView(R.id.tvRegMoney).setText(item.getRegCapital());
                holder.getTextView(R.id.tvClDate).setText(item.getEstablishDate());
            }
        };
        rcv.setAdapter(myAdapter);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getCompanyList();
            }

            @Override
            public void onLoadMore() {

            }
        });
        rcv.setRefreshing(true);
        myAdapter.setOnItemClickListener(this);

    }


    @Override
    public void setCompanyData(List<CompanyBean> mdatas) {
        this.datas=mdatas;
        rcv.refreshComplete();
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

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle=new Bundle();
        bundle.putString(CompanyAct.COMAPYT_ID,datas.get(position-1).getId());
        openActivity(CompanyAct.class,bundle);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
