package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.SearchHistoryAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.ui.CompanyAct;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchShareholderPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchShareholderPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchShareholderView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
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

/**
 * 查法人/股东
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchShareholderAct extends BaseAct<ISearchShareholderPresenter> implements ISearchShareholderView,View.OnClickListener {
    @BindView(R.id.xr)
    XRecyclerView xr;
    @BindView(R.id.query)
    ClearEditText query;
    @BindView(R.id.size_flow_layout)
    FlowTagLayout sizeFlowLayout;//最近搜索流式布局
    @BindView(R.id.rl_patent)
    RelativeLayout rl_patent;//专利
    BaseRecyclerAdapter<CompanyBean> myAdapter;//查商标适配器
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
    @BindView(R.id.iv_sc)
    ImageView ivSc;//最近搜索删除
    List<CompanyBean> datas = new ArrayList<>();
    int page = 1;
    int rows = 10;
    String patentType="0";//0：近似查询、1：精确查询、2：申请人
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    List<String> hotNames = new ArrayList<>();
    SearchHistoryAdapter<String> recentAdatper;//最近搜索适配器
    SearchHistoryAdapter<String> hotAdapter;//热门搜索适配器
    String stockMsgName,capital,establishDate,address,industry;
    @Override
    public int getLayout() {
        return R.layout.search_shareholder;
    }

    @Override
    public void init(Bundle savedInstanceState) {
//        datas = EchinfoUtils.getTestDatas(4);
//        rcv = (XRecyclerView) findViewById(R.id.rcv);
//        rl_sj = (RelativeLayout) findViewById(R.id.rl_sj);
//        rl_lx = (RelativeLayout) findViewById(R.id.rl_lx);
//        ll_sx = (LinearLayout) findViewById(R.id.ll_sx);
//        rm = (XRecyclerView) findViewById(R.id.rm);
//        recent = (XRecyclerView) findViewById(R.id.xr);
//        query= (EditText) findViewById(R.id.query);
//        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
//        initData();
//        inithotReSou();
//        initRecentSearch();
        mPresenter = new SearchShareholderPresenterImpl(this);
        aCache=ACache.get(SearchShareholderAct.this);
        gson=new Gson();
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), true);
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchShareholderAct.this.getCurrentFocus()
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
        mPresenter.getHotHistory("EnterpriseInfo");
        //填充最近搜索
        initRecentSearch();
        //填充热门搜索
        inithotReSou();
    }
    /**
     * 点击键盘搜索
     */
    private void search() {
        stockMsgName = query.getText().toString().trim();
        if (TextUtils.isEmpty(stockMsgName)) {
            toast("输入内容空，请重新输入");
            return;
        } else {
            // 调用搜索的API方法
            ToolsUtils.hideSoftKeyboard(SearchShareholderAct.this);
            mPresenter.getQiYeinfo(stockMsgName,address,industry,capital,establishDate,page,rows);
        }

    }

//    /**
//     * 填充最近搜索内容
//     */
//    private void initRecentSearch() {
//        myAdapter= new BaseRecyclerAdapter<CompanyBean>(getApplicationContext(), datas) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_rm_item;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
//
//            }
//        };
//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recent.setLayoutManager(linearLayoutManager);
//        recent.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//    }
//
//    /**
//     * 热门搜索数据填充
//     */
//
//    private void inithotReSou() {
//        myAdapter= new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_rm_item;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
//
//            }
//        };
//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rm.setLayoutManager(linearLayoutManager);
//        rm.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//    }
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
                stockMsgName = hotNames.get(position);
                query.setText(stockMsgName);
                query.setSelection(stockMsgName.length());
                rl_patent.setFocusable(true);
                rl_patent.setFocusableInTouchMode(true);
                rl_patent.requestFocus();
                page = 1;
                mPresenter.getQiYeinfo(stockMsgName,address,industry,capital,establishDate,page,rows);
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
                stockMsgName = names.get(position);
                query.setText(stockMsgName);
                query.setSelection(stockMsgName.length());
                rl_patent.setFocusable(true);
                rl_patent.setFocusableInTouchMode(true);
                rl_patent.requestFocus();
                page = 1;
                mPresenter.getQiYeinfo(stockMsgName,address,industry,capital,establishDate,page,rows);
            }
        });
        String strTime = null;
        strTime = aCache.getAsString("ShareholderHistory");
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
     * 填充数据
     */
//    private void initData() {
//        query.setHint("请输入法定代表人或股东名");
//        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_search_shareholder;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
//
//            }
//        };
//        rl_sj.setOnClickListener(this);
//        rl_lx.setOnClickListener(this);
//        rcv.setAdapter(myAdapter);
//
//    }
    /**
     * 数据列表
     */
    private void initData() {
        query.setHint("请输入法定代表人或股东");
        myAdapter = new BaseRecyclerAdapter<CompanyBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_shareholder;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getName());
                holder.getTextView(R.id.tv_status).setText(item.getManagementStatus());
                holder.getTextView(R.id.tv_gs).setText(item.getCompanyName());
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
                mPresenter.getQiYeinfo(stockMsgName,address,industry,capital,establishDate,page,rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getQiYeinfo(stockMsgName,address,industry,capital,establishDate,page,rows);
            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID,datas.get(position).getId());
                openActivity(CompanyAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_sj:
                break;
            case R.id.rl_lx:
//                selectPop();
                break;
        }
    }

    @Override
    public void findEnterpriseInfoByNameSuceess(List<CompanyBean> list) {
        ToolsUtils.hideSoftKeyboard(SearchShareholderAct.this);
        rlSearch.setVisibility(View.GONE);
        llJg.setVisibility(View.VISIBLE);
        ll_rcv.setVisibility(View.VISIBLE);
        String strTime = null;
        strTime = aCache.getAsString("ShareholderHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(stockMsgName)) {
                nameNews.add(stockMsgName);
                aCache.put("ShareholderHistory", GsonUtils.bean2Json(nameNews));
                recentAdatper.onlyAddAll(nameNews);
            }
        } else {
            List<String> nameNews = new ArrayList<>();
            nameNews.add(stockMsgName);
            aCache.put("ShareholderHistory", GsonUtils.bean2Json(nameNews));
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
    public void findEnterpriseInfoByNameFaild(int status, String errorMsg) {
        xr.refreshComplete();
        xr.loadMoreComplete();
        toast(errorMsg);
    }

    @Override
    public void findfindEnterpriseInfoByNameNodata() {
        rlSearch.setVisibility(View.GONE);
        xr.refreshComplete();
        xr.loadMoreComplete();
    }

    @Override
    public void findEnterpriseTotals(int tatal) {
        if (tatal > 0) {
            llJg.setVisibility(View.VISIBLE);
            tvJs.setText("搜索到" + tatal + "个公司");
        }
    }

    @Override
    public void getHotHistorySucess(List<CompanyBean> suceessMsg) {
        if (hotNames != null && hotNames.size() > 0) {
            hotNames.clear();
        }
        if (suceessMsg != null && suceessMsg.size() > 0) {
            for (int i = 0; i < suceessMsg.size(); i++) {
                if (!TextUtils.isEmpty(suceessMsg.get(i).getCompanyName())){
                    hotNames.add(suceessMsg.get(i).getCompanyName());
                }
            }
            hotAdapter.onlyAddAll(hotNames);
        }
    }

    @Override
    public void getHotHistoryFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

//    class XzSimpleAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return strSx.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return strSx[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = View.inflate(getApplicationContext(), R.layout.rcv_item_select, null);
//            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
//            tv_title.setText(strSx[position]);
//            return convertView;
//        }
//    }

    /**
     * 选择对话框
     */
//    private void selectPop() {
//        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.act_select, null);
//        mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
//        ListView lv = (ListView) v.findViewById(R.id.lv);
//        lv.setAdapter(new XzSimpleAdapter());
//        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
//        int xpos = manager.getDefaultDisplay().getWidth() / 2 - mPopupWindow.getWidth() / 2;
//        //xoff,yoff基于anchor的左下角进行偏移。
//        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
//        mPopupWindow.setAnimationStyle(R.style.ppAnimBottom);
//        mPopupWindow.setFocusable(true);
//        mPopupWindow.showAsDropDown(ll_sx, xpos, 0);
//    }
}
