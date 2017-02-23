package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.ProductBean;
import com.boyuanitsm.echinfo.module.company.presenter.IProductListPre;
import com.boyuanitsm.echinfo.module.company.presenter.ProductListPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IProductInfoView;
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
 * 产品信息列表
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class ProductListAct extends BaseAct<IProductListPre> implements IProductInfoView {
    @BindView(R.id.xr)
    XRecyclerView xr;//下拉刷新view
    BaseRecyclerAdapter<ProductBean> myAdapter;//查商标适配器
    private List<ProductBean> datas = new ArrayList<>();
    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.act_product_list;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("产品信息");
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter = new ProductListPreImpl(this);
        initData();
        mPresenter.getProductList(companyId);//获取查判决热门词语
    }

    private void initData() {
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        myAdapter = new BaseRecyclerAdapter<ProductBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_product;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, ProductBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getName());
                holder.getTextView(R.id.tv_content).setText(item.getProductPresentation());
            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(linearLayoutManager);
        xr.setAdapter(myAdapter);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getProductList(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(ProductInfoAct.PRODUCT_INFO, datas.get(position - 1));
                openActivity(ProductInfoAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void getProductListSucess(List<ProductBean> list) {
        datas = list;
        myAdapter.setData(datas);
    }

    @Override
    public void getProductListFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void getProductNodata() {
        toast("暂无数据");
    }
}
