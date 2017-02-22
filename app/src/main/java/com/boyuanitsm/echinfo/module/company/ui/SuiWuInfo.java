package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.TaxInfoBean;
import com.boyuanitsm.echinfo.module.company.presenter.ISuiWuInfoPre;
import com.boyuanitsm.echinfo.module.company.presenter.SuiWuInfoPreImpl;
import com.boyuanitsm.echinfo.module.company.view.ISuiWuInfoView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 税务信用
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class SuiWuInfo extends BaseAct<ISuiWuInfoPre> implements ISuiWuInfoView {
    @BindView(R.id.xr)
    XRecyclerView xr;//下拉刷新view
    BaseRecyclerAdapter<TaxInfoBean> myAdapter;//查商标适配器
    private List<TaxInfoBean> datas = new ArrayList<>();
    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.act_suiwu_layout;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("税务信息");
        mPresenter = new SuiWuInfoPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        initData();
        mPresenter.getSuiWuInfo(companyId);//获取查判决热门词语
    }

    private void initData() {
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        myAdapter = new BaseRecyclerAdapter<TaxInfoBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_suiwu;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, TaxInfoBean item) {
                holder.getTextView(R.id.tv_nd).setText("评价年度：" + item.getEvaluationYear());
                holder.getTextView(R.id.tv_ns).setText(item.getNormalTax());
                holder.getTextView(R.id.tv_qs).setText(item.getWhetherTaxes());
                holder.getTextView(R.id.tv_xy).setText(item.getQualityRating());
                holder.getTextView(R.id.tv_je).setText(item.getBalance());
                holder.getTextView(R.id.tv_bh).setText(item.getIdentifyNumber());
                holder.getTextView(R.id.tv_dw).setText(item.getEvaluationUnit());


            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(linearLayoutManager);
        xr.setAdapter(myAdapter);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getSuiWuInfo(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID, datas.get(position - 1).getId());
                openActivity(CompanyAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void getISuiWuInfoSucess(List<TaxInfoBean> data) {
        datas=data;
        myAdapter.setData(datas);
    }

    @Override
    public void getSuiWuInfoFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void getNoData() {

    }
}
