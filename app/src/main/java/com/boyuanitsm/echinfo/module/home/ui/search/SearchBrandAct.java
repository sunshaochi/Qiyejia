package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.SearchHistoryAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchBrandPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchBrandPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchBrandView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.utils.GsonUtils;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagClickListener;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2016/12/30.
 */

public class SearchBrandAct extends BaseAct<ISearchBrandPresenter> implements ISearchBrandView {
    @BindView(R.id.xr)
    XRecyclerView xr;
    @BindView(R.id.query)
    ClearEditText query;
    @BindView(R.id.size_flow_layout)
    FlowTagLayout sizeFlowLayout;//最近搜索流式布局
    @BindView(R.id.rl_patent)
    RelativeLayout rl_patent;//专利
    BaseRecyclerAdapter<BrandBean> myAdapter;//查商标适配器
    @BindView(R.id.rl_recent)
    RelativeLayout rlRecent;//最近搜索
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;//无搜索记录展示
    @BindView(R.id.ll_jg)
    LinearLayout llJg;//搜索到专利总数
    @BindView(R.id.ll_rcv)
    LinearLayout ll_rcv;//专利结果展示
    @BindView(R.id.ll_rs)
    LinearLayout llRs;//热门搜索
    @BindView(R.id.tv_js)
    TextView tvJs;//搜索到5000个专利
    @BindView(R.id.rm)
    FlowTagLayout rm;//热门搜索
    List<BrandBean> datas = new ArrayList<>();
    int page = 1;
    int rows = 10;
    String name;
    String patentType="0";//0：近似查询、1：精确查询、2：申请人
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    List<String> hotNames = new ArrayList<>();
    SearchHistoryAdapter<String> recentAdatper;//最近搜索适配器
    SearchHistoryAdapter<String> hotAdapter;//热门搜索适配器
    @Override
    public int getLayout() {
        return R.layout.search_brand;
    }

    @Override
    public void init(Bundle savedInstanceState) {
//        datas = EchinfoUtils.getTestDatas(4);
        mPresenter = new SearchBrandPresenterImpl(this);
        aCache=ACache.get(SearchBrandAct.this);
        gson=new Gson();
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), true);
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchBrandAct.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    search();
                }
                return false;
            }
        });
        query.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    llRs.setVisibility(View.VISIBLE);
                } else {
                    llRs.setVisibility(View.GONE);
                    rlSearch.setVisibility(View.GONE);
                }
            }
        });
        initData();
        //获取热门搜索词语
        mPresenter.getHotHistory("Trademark");
        //填充最近搜索
        initRecentSearch();
        //填充热门搜索
        inithotReSou();
    }

    /**
     * 热门搜索
     */
    private void inithotReSou() {
        hotAdapter = new SearchHistoryAdapter<>(this);
        rm.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);//设置是单选
        rm.setAdapter(hotAdapter);
        rm.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                name = hotNames.get(position);
                query.setText(name);
                query.setSelection(name.length());
                rl_patent.setFocusable(true);
                rl_patent.setFocusableInTouchMode(true);
                rl_patent.requestFocus();
                page = 1;
                mPresenter.findBrandInfo(name, patentType,  page, rows);
            }
        });
    }

    private void initRecentSearch() {
        recentAdatper = new SearchHistoryAdapter<>(this);
        sizeFlowLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);
        sizeFlowLayout.setAdapter(recentAdatper);
        sizeFlowLayout.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                name = names.get(position);
                query.setText(name);
                query.setSelection(name.length());
                rl_patent.setFocusable(true);
                rl_patent.setFocusableInTouchMode(true);
                rl_patent.requestFocus();
                page = 1;
                mPresenter.findBrandInfo(name, patentType,  page, rows);
            }
        });
        String strTime = null;
        strTime = aCache.getAsString("BrandHistory");
        if (!TextUtils.isEmpty(strTime)) {
            query.setFocusable(true);
            query.setFocusableInTouchMode(true);
            query.requestFocus();
            rlRecent.setVisibility(View.VISIBLE);
            rlSearch.setVisibility(View.GONE);
            names = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            recentAdatper.onlyAddAll(names);
        } else {
            rlSearch.setVisibility(View.VISIBLE);
            rlRecent.setVisibility(View.GONE);
        }
    }

    /**
     * 点击键盘搜索
     */
    private void search() {
        name = query.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            toast("输入内容空，请重新输入");
            return;
        } else {
            // 调用搜索的API方法
            ToolsUtils.hideSoftKeyboard(SearchBrandAct.this);
            mPresenter.findBrandInfo(name, patentType, page, rows);
        }

    }

    /**
     * 数据列表
     */
    private void initData() {
        query.setHint("请输入注册号，商标名或公司名");
        myAdapter = new BaseRecyclerAdapter<BrandBean>(getApplicationContext(), datas) {
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
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void findBrandInfoSucess(List<BrandBean> list) {
        ToolsUtils.hideSoftKeyboard(SearchBrandAct.this);
        rlSearch.setVisibility(View.GONE);
        llJg.setVisibility(View.VISIBLE);
        ll_rcv.setVisibility(View.VISIBLE);
        String strTime = null;
        strTime = aCache.getAsString("BrandHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(name)) {
                nameNews.add(name);
                aCache.put("BrandHistory", GsonUtils.bean2Json(nameNews));
                recentAdatper.onlyAddAll(nameNews);
            }
        } else {
            List<String> nameNews = new ArrayList<>();
            nameNews.add(name);
            aCache.put("BrandHistory", GsonUtils.bean2Json(nameNews));
            recentAdatper.onlyAddAll(nameNews);
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
        rlSearch.setVisibility(View.GONE);
        xr.refreshComplete();
        xr.loadMoreComplete();
    }

    @Override
    public void findBrandTotal(int totals) {
        if (totals > 0) {
            llJg.setVisibility(View.VISIBLE);
            tvJs.setText("搜索到" + totals + "个专利");
        }
    }

    @Override
    public void getHotHistorySucess(List<BrandBean> suceessMsg) {
        if (hotNames != null && hotNames.size() > 0) {
            hotNames.clear();
        }
        if (suceessMsg != null && suceessMsg.size() > 0) {
            for (int i = 0; i < suceessMsg.size(); i++) {
                hotNames.add(suceessMsg.get(i).getName());
            }
            hotAdapter.onlyAddAll(hotNames);
        }
    }

    @Override
    public void getHotHistoryFaild(int status, String errorMsg) {
        toast(errorMsg);

    }
}
