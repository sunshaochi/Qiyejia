package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.module.company.presenter.FindBrandInfoPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.IFindBrandInfoPre;
import com.boyuanitsm.echinfo.module.company.view.IFindBrandInfoView;
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
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class FindBrandInfoAct extends BaseAct<IFindBrandInfoPre> implements IFindBrandInfoView {
    @BindView(R.id.xr)
    XRecyclerView xr;
    private BaseRecyclerAdapter<BrandBean> mAdaptar;
    private List<BrandBean> datas = new ArrayList<>();
    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.act_brand_list;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("商标信息");
        initdata();
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter=new FindBrandInfoPreImpl(this);
        mPresenter.findBrandInfoList(companyId);
    }

    /**
     * 填充数据
     */
    private void initdata() {
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        mAdaptar = new BaseRecyclerAdapter<BrandBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.xr_item_searchbrand;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, BrandBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getName());
                holder.getTextView(R.id.tv_status).setText(item.getStatus());
                holder.getTextView(R.id.tv_sblx).setText(item.getType());
            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(linearLayoutManager);
        xr.setAdapter(mAdaptar);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.findBrandInfoList(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
        mAdaptar.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(BrandInfoAct.BRANDINFO, datas.get(position - 1));
                openActivity(CompanyAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void getBrandListSucess(List<BrandBean> list) {
            datas=list;
        mAdaptar.setData(datas);
    }

    @Override
    public void getBrandListFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void getBrandNodata() {

    }
}
