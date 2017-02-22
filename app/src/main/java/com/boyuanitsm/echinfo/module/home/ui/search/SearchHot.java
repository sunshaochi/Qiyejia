package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.ui.CompanyAct;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchHotPreImpl;
import com.boyuanitsm.echinfo.module.home.view.ISearchHotView;
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
 * 企业热门搜索
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class SearchHot extends BaseAct<ISearchHotPreImpl> implements ISearchHotView {
    @BindView(R.id.xr)
    XRecyclerView xr;//下拉刷新view
    BaseRecyclerAdapter<CompanyBean> myAdapter;//查商标适配器
    private List<CompanyBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_hot_qiye;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("热门企业");
        mPresenter = new ISearchHotPreImpl(this);
        initData();
        mPresenter.getHotHistory("EnterpriseInfo");//获取查判决热门词语
    }

    private void initData() {
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        myAdapter = new BaseRecyclerAdapter<CompanyBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_serch_name;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_person).setText("公司法人：" + item.getLegalPerson());
                holder.getTextView(R.id.tv_status).setText(item.getManagementStatus());
                holder.getTextView(R.id.tv_sb).setText("商标/产品：" + item.getName());
            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(linearLayoutManager);
        xr.setAdapter(myAdapter);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getHotHistory("EnterpriseInfo");
            }

            @Override
            public void onLoadMore() {

            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID,datas.get(position-1).getId());
                openActivity(CompanyAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void getHotHistorySucess(List<CompanyBean> suceessMsg) {
        datas = suceessMsg;
        myAdapter.setData(datas);
    }

    @Override
    public void getHotHistoryFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void getNodata() {

    }
}
