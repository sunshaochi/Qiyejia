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
import com.boyuanitsm.echinfo.bean.LoseCreditBean;
import com.boyuanitsm.echinfo.bean.LoseCreditDatabean;
import com.boyuanitsm.echinfo.bean.LoseCreditRowsBean;
import com.boyuanitsm.echinfo.module.company.ui.CreditDetailAct;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchLoseCreditPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchLoseCreditPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchLoseCreditView;
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
import butterknife.OnClick;

/**
 * 查失信
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchlosecreditAct extends BaseAct<ISearchLoseCreditPresenter> implements ISearchLoseCreditView, View.OnClickListener {
    @BindView(R.id.query)
    ClearEditText query;
    @BindView(R.id.size_flow_layout)
    FlowTagLayout sizeFlowLayout;//最近搜索流式布局
    @BindView(R.id.rl_patent)
    RelativeLayout rl_patent;//专利
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
    BaseRecyclerAdapter<LoseCreditBean> myAdapter;//查商标适配器
    List<LoseCreditBean> datas = new ArrayList<>();
    int page = 1;
    int rows = 10;
    int totals=0;
    String name;
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    List<String> hotNames = new ArrayList<>();
    SearchHistoryAdapter<String> recentAdatper;//最近搜索适配器
    SearchHistoryAdapter<String> hotAdapter;//热门搜索适配器
    @BindView(R.id.xr)
    XRecyclerView xr;

    @Override
    public int getLayout() {
        return R.layout.search_losecredit;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter = new SearchLoseCreditPresenterImpl(this);
        gson = new Gson();
        aCache = ACache.get(SearchlosecreditAct.this);
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), true);
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchlosecreditAct.this.getCurrentFocus()
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
        mPresenter.getHotHistory("Courtitem");//获取查判决热门词语
        inithotReSou();
        initRecentSearch();
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
            ToolsUtils.hideSoftKeyboard(SearchlosecreditAct.this);
            mPresenter.findLoseCreditInfo(name, page, rows);
        }

    }

    /**
     * 填充最近搜索内容
     */
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
                mPresenter.findLoseCreditInfo(name, page, rows);
            }
        });
        String strTime = null;
        strTime = aCache.getAsString("LoseCreditHistory");
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
     * 热门搜索数据填充
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
                mPresenter.findLoseCreditInfo(name, page, rows);
            }
        });
    }

    /**
     * 填充数据
     */
    private void initData() {
        query.setHint("请输入失信人或失信公司");
        myAdapter = new BaseRecyclerAdapter<LoseCreditBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_losecredit;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, LoseCreditBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getIname());
                holder.getTextView(R.id.tv_rq).setText("发布日期：" + item.getPublishdate());
                holder.getTextView(R.id.tv_wh).setText("依据文号：" + item.getCasecode());
//                holder.getTextView(R.id.tv_status).setText(item.getsType());
                holder.getTextView(R.id.tv_fy).setText("执行法院：" + item.getCourtname());
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
                mPresenter.findLoseCreditInfo(name, page, rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.findLoseCreditInfo(name, page, rows);
            }
        });
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putParcelable(CreditDetailAct.CREDIT_DETAIL,datas.get(position-1));
                openActivity(CreditDetailAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    @OnClick({R.id.iv_sc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_sc:
                aCache.put("LoseCreditHistory", "");
                rlRecent.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void findLoseCreditInfoSucess(LoseCreditDatabean databean) {
        ToolsUtils.hideSoftKeyboard(SearchlosecreditAct.this);
        rlSearch.setVisibility(View.GONE);
        llJg.setVisibility(View.VISIBLE);
        ll_rcv.setVisibility(View.VISIBLE);
        String strTime = null;
        strTime = aCache.getAsString("LoseCreditHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(name)) {
                nameNews.add(name);
                aCache.put("LoseCreditHistory", GsonUtils.bean2Json(nameNews));
                recentAdatper.onlyAddAll(nameNews);
            }
        } else {
            List<String> nameNews = new ArrayList<>();
            nameNews.add(name);
            aCache.put("LoseCreditHistory", GsonUtils.bean2Json(nameNews));
            recentAdatper.onlyAddAll(nameNews);
        }


        if (page == 1) {
            xr.refreshComplete();
            datas.clear();
        }
        xr.loadMoreComplete();
        if (databean!=null){
            LoseCreditRowsBean courtPerson = databean.getCourtPerson();
            totals= courtPerson.getTotal();
            if (courtPerson!=null){
                List<LoseCreditBean> rows = courtPerson.getRows();
                if (rows!=null&&rows.size()>0){
                    datas.addAll(rows);
                }
            }
            LoseCreditRowsBean courtUnit = databean.getCourtUnit();
            totals=totals+courtUnit.getTotal();
            if (courtUnit!=null){
                List<LoseCreditBean> rows = courtUnit.getRows();
                if (rows!=null&&rows.size()>0){
                    datas.addAll(rows);
                }
            }
        }
        if (totals > 0) {
            llJg.setVisibility(View.VISIBLE);
            tvJs.setText("搜索到" + totals + "条失信记录");
        }
        myAdapter.setData(datas);
    }

    @Override
    public void findLoseCreditInfoFaild(int status, String errorMsg) {
        xr.refreshComplete();
        xr.loadMoreComplete();
        toast(errorMsg);
    }

    @Override
    public void findLoseCreditNoData() {
        rlSearch.setVisibility(View.GONE);
        xr.refreshComplete();
        xr.loadMoreComplete();
    }

    @Override
    public void findLoseCreditTotal(int totals) {
    }

    @Override
    public void getHotHistorySucess(LoseCreditDatabean suceessMsg) {
        if (hotNames != null && hotNames.size() > 0) {
            hotNames.clear();
        }
        if (suceessMsg != null ) {
            LoseCreditRowsBean courtPerson = suceessMsg.getCourtPerson();
            if (courtPerson!=null){
                List<LoseCreditBean> rows = courtPerson.getRows();
                courtPerson.getTotal();
                if (rows!=null&&rows.size()>0){
                    for (int i = 0; i < rows.size(); i++) {
                        if (!TextUtils.isEmpty(rows.get(i).getIname())){
                            hotNames.add(rows.get(i).getIname());
                        }
                    }
                }
            }
            LoseCreditRowsBean courtUnit = suceessMsg.getCourtUnit();
            if (courtUnit!=null){
                List<LoseCreditBean> rows = courtUnit.getRows();
                if (rows!=null&&rows.size()>0){
                    for (int i = 0; i < rows.size(); i++) {
                        if (!TextUtils.isEmpty(rows.get(i).getIname())){
                            hotNames.add(rows.get(i).getIname());
                        }
                    }
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
//
//    /**
//     * 选择对话框
//     */
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
