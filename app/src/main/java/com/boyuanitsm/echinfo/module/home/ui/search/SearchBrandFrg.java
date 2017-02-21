package com.boyuanitsm.echinfo.module.home.ui.search;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.module.company.ui.BrandInfoAct;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchBrandPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchBrandPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchBrandView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.GsonUtils;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2016/12/30.
 */

public class SearchBrandFrg extends BaseFrg<ISearchBrandPresenter> implements ISearchBrandView {
    @BindView(R.id.xr)
    XRecyclerView xr;
    @BindView(R.id.tv_js)
    TextView tvJs;//搜索到5000个专利
    @BindView(R.id.ll_jg)
    LinearLayout llJg;//搜索到专利总数

    @BindView(R.id.ll_rcv)
    LinearLayout ll_rcv;//专利结果展示

    List<BrandBean> datas = new ArrayList<>();
    int page = 1;
    int rows = 10;
    String patentType="0";//0：近似查询、1：精确查询、2：申请人
    BaseRecyclerAdapter<BrandBean> myAdapter;//查商标适配器
    public static final String INPUT_TYPE="find_input_type";
    ACache aCache;
    String  name;
    Gson gson;

    @Override
    public int getLayout() {
        return R.layout.search_brand;
    }

    @Override
    protected void initView(View fragmentRootView) {
        patentType = getArguments().getString(INPUT_TYPE);
        mPresenter = new SearchBrandPresenterImpl(this);
        aCache=ACache.get(mActivity);
        gson=new Gson();
        xr = EchinfoUtils.getLinearRecyclerView(xr, mActivity, true);
        initData();


    }
//
//    @Override
//    public void init(Bundle savedInstanceState) {
////        datas = EchinfoUtils.getTestDatas(4);
//
//    }





    /**
     * 数据列表
     */
    private void initData() {

        myAdapter = new BaseRecyclerAdapter<BrandBean>(mActivity, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.xr_searchbrand;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, BrandBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getName());
                holder.getTextView(R.id.tv_status).setText(item.getStatus());
                holder.getTextView(R.id.tv_rq).setText("申请日期："+item.getApplicatTime());
                holder.getTextView(R.id.tv_lx).setText("商标类型："+item.getType());
                holder.getTextView(R.id.tv_sqr).setText("申请人："+item.getApplicatPerson());
            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(linearLayoutManager);
        xr.setAdapter(myAdapter);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.findBrandInfo(name, patentType, page, rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.findBrandInfo(name, patentType, page, rows);
            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putParcelable(BrandInfoAct.BRANDINFO,datas.get(position-1));
                openActivity(BrandInfoAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }


    @Override
    public void findBrandInfoSucess(List<BrandBean> list) {
        ToolsUtils.hideSoftKeyboard(mActivity);
//        rlSearch.setVisibility(View.GONE);
//        llJg.setVisibility(View.VISIBLE);
//        ll_rcv.setVisibility(View.VISIBLE);
        String strTime = null;
        strTime = aCache.getAsString("BrandHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(name)) {
                nameNews.add(name);
                aCache.put("BrandHistory", GsonUtils.bean2Json(nameNews));
//                recentAdatper.onlyAddAll(nameNews);
            }
        } else {
            List<String> nameNews = new ArrayList<>();
            nameNews.add(name);
            aCache.put("BrandHistory", GsonUtils.bean2Json(nameNews));
//            recentAdatper.onlyAddAll(nameNews);
        }


        if (page == 1) {
            xr.refreshComplete();
            datas.clear();
        }
        xr.loadMoreComplete();
        datas.addAll(list);
        myAdapter.setData(datas);

    }

    @Override
    public void findBrandInfoFaild(int status, String errorMsg) {
        xr.refreshComplete();
        xr.loadMoreComplete();
        toast(errorMsg);
    }

    @Override
    public void findBrandNoData() {

    }

    @Override
    public void findBrandTotal(int totals) {
        if (totals > 0) {
            llJg.setVisibility(View.VISIBLE);
            tvJs.setText("搜索到" + totals + "个商标");
        }
    }
    private MyReceiver myReceiver;
    public static final String BRAND_UPDATA = "com.brand_updata";

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            page=1;
            name=  intent.getStringExtra("name");
            mPresenter.findBrandInfo(name,patentType,page,rows);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
            mActivity.registerReceiver(myReceiver, new IntentFilter(BRAND_UPDATA));
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            mActivity.unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }
}
