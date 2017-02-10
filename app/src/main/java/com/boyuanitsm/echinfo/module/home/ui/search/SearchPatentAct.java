package com.boyuanitsm.echinfo.module.home.ui.search;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.SearchHistoryAdapter;
import com.boyuanitsm.echinfo.adapter.XzSimpleAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.PatentBean;
import com.boyuanitsm.echinfo.bean.PatentTypeBean;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchPatentPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchPatentPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchPatentView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.utils.GsonUtils;
import com.boyuanitsm.tools.utils.MyLogUtils;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagSelectListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchPatentAct extends BaseAct<ISearchPatentPresenter> implements ISearchPatentView, View.OnClickListener {
    @BindView(R.id.query)
    ClearEditText query;//搜索框
    @BindView(R.id.tv_sj)
    TextView tvSj;//时间
    @BindView(R.id.rl_sj)
    RelativeLayout rlSj;//时间
    @BindView(R.id.tv_lx)
    TextView tv_lx;//专利类型
    @BindView(R.id.iv_lx)
    ImageView iv_lx;//专利类型箭头
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    @BindView(R.id.rl_recent)
    RelativeLayout rlRecent;//最近搜索
    @BindView(R.id.tv_rm)
    TextView tvRm;
    @BindView(R.id.rm)
    FlowTagLayout rm;//热门搜索
    @BindView(R.id.rl_lx)
    RelativeLayout rlLx;//类型
    @BindView(R.id.ll_sx)
    LinearLayout llSx;
    @BindView(R.id.ll_jg)
    LinearLayout llJg;
    @BindView(R.id.recent)
    TextView recent;
    @BindView(R.id.ll_rs)
    LinearLayout llRs;
    @BindView(R.id.tv_js)
    TextView tvJs;
    @BindView(R.id.iv_sj)
    ImageView ivSj;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.size_flow_layout)
    FlowTagLayout sizeFlowLayout;
    @BindView(R.id.iv_sc)
    ImageView ivSc;
    @BindView(R.id.rl_hot)
    RelativeLayout rl_hot;
    private BaseRecyclerAdapter<PatentBean> myAdapter;//推荐阅读适配器
    private List<PatentBean> datas = new ArrayList<>();//专利列表
    private List<PatentTypeBean> typedatas = new ArrayList<>();//专利类型
    private PopupWindow mPopupWindow;
    private XzSimpleAdapter xzSimpleAdapter;
    String name;//搜索名字
    String patentType;//专利类型
    String releaseDate;//年份
    int page = 1;
    int rows = 10;
    int clickPos = 0;
    int intFlag = 0;//1是获取类型成功2是获取失败
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    private SearchHistoryAdapter<String> mSizeTagAdapter;//最近搜索适配器

    @Override
    public int getLayout() {
        return R.layout.search_patent;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter = new SearchPatentPresenterImpl(this);
        iv_lx.setImageResource(R.mipmap.down_gray);
        ivSj.setImageResource(R.mipmap.down_gray);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        aCache = ACache.get(SearchPatentAct.this);
        gson = new Gson();
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchPatentAct.this.getCurrentFocus()
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
                }
            }
        });
//        query.onFocusChange();
        initData();
        //获取专利类型
        mPresenter.getPatentType("paten_type_key");
        initRecentSearch();
//        inithotReSou();

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
            ToolsUtils.hideSoftKeyboard(SearchPatentAct.this);
            mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
        }

    }

    /**
     * 填充最近搜索内容
     */
    private void initRecentSearch() {
        mSizeTagAdapter = new SearchHistoryAdapter<>(this);
        sizeFlowLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);//设置是单选
        sizeFlowLayout.setAdapter(mSizeTagAdapter);
        sizeFlowLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {

            }
        });
        String strTime;
        strTime = aCache.getAsString("PatentHistory");
        if (!TextUtils.isEmpty(strTime)) {
            rlRecent.setVisibility(View.VISIBLE);
            rlSearch.setVisibility(View.GONE);
            names = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            mSizeTagAdapter.onlyAddAll(names);
        } else {
            rlSearch.setVisibility(View.VISIBLE);
            rlRecent.setVisibility(View.GONE);
        }
    }

    /**
     * 热门搜索数据填充
     */

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
     * 填充数据
     */
    private void initData() {
        query.setHint("请输入专利号，专利名，公司名");
        myAdapter = new BaseRecyclerAdapter<PatentBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_patent;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, PatentBean item) {
                holder.getTextView(R.id.tv_Name).setText(item.getName());
                holder.getTextView(R.id.tv_sq).setText("申请人：" + item.getApplicatPerson());
                holder.getTextView(R.id.tv_rq).setText("申请日期：" + item.getReleaseDate());
                holder.getTextView(R.id.tv_flh).setText("主类分号：" + item.getApplicationNo());
            }
        };
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                MyLogUtils.info(page + "page======");
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }
        });

    }
    @Override
    public void findPatentInfoSucess(List<PatentBean> list) {
//        rlRecent.setVisibility(View.GONE);
        String strTime = null;
        strTime = aCache.getAsString("PatentHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(name)) {
                nameNews.add(name);
                aCache.put("PatentHistory", GsonUtils.bean2Json(nameNews));
                mSizeTagAdapter.onlyAddAll(nameNews);
            }
        }


        if (page == 1) {
            rcv.refreshComplete();
            datas.clear();
        }
        rcv.loadMoreComplete();
        datas.addAll(list);
        myAdapter.setData(datas);
    }

    @Override
    public void findPatentInfoFaild(int status, String errorMsg) {
        rcv.refreshComplete();
        rcv.loadMoreComplete();
        toast(errorMsg);
    }

    @Override
    public void findPatentNoData() {
        rcv.refreshComplete();
        rcv.loadMoreComplete();
        llJg.setVisibility(View.GONE);
    }

    @Override
    public void findPatentTotal(int totals) {
        if (totals > 0) {
            llJg.setVisibility(View.VISIBLE);
            tvJs.setText("搜索到" + totals + "个专利");
        } else {
            llJg.setVisibility(View.GONE);
        }
    }

    @Override
    public void getPatentTypeSucess(List<PatentTypeBean> suceessMsg) {
        PatentTypeBean patentTypeBean = new PatentTypeBean();
        patentTypeBean.setDictName("类型不限");
        suceessMsg.add(0, patentTypeBean);
        typedatas = suceessMsg;
        intFlag = 1;
    }


    @Override
    public void getPatentTypeFaild(int status, String errorMsg) {
        intFlag = 2;
    }

    /**
     * 时间类型
     * 选择对话框
     */
    private void selectPop(final List<PatentTypeBean> typeBean) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.act_select, null);
        mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        ListView lv = (ListView) v.findViewById(R.id.lv);
        LinearLayout ll_dimis = (LinearLayout) v.findViewById(R.id.ll_dimis);
        xzSimpleAdapter = new XzSimpleAdapter(SearchPatentAct.this, typeBean, clickPos);
        lv.setAdapter(xzSimpleAdapter);
//        tvSj.setTextColor(Color.parseColor("#2485f2"));
//        ivSj.setImageResource(R.mipmap.sjtxx);
        tv_lx.setTextColor(Color.parseColor("#2485f2"));
        iv_lx.setImageResource(R.mipmap.sjtxx);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    patentType = "";
                } else {
                    patentType = typeBean.get(position).getDictName();
                }
                clickPos = position;
                mPopupWindow.dismiss();
                page = 1;
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }
        });
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (!TextUtils.isEmpty(patentType)) {
                    tv_lx.setText(patentType);
                } else {
                    tv_lx.setText("类型不限");
                }
                tv_lx.setTextColor(Color.parseColor("#000000"));
                iv_lx.setImageResource(R.mipmap.down_gray);
            }
        });
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        int xpos = manager.getDefaultDisplay().getWidth() / 2 - mPopupWindow.getWidth() / 2;
        //xoff,yoff基于anchor的左下角进行偏移。
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        mPopupWindow.setAnimationStyle(R.style.ppAnimBottom);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAsDropDown(llSx, xpos, 0);
        ll_dimis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_lx, R.id.iv_sc, R.id.rl_recent, R.id.rl_hot, R.id.ll_rs})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_lx:
                if (intFlag == 1) {
                    selectPop(typedatas);
                } else {
                    toast("获取专利类型失败");
                }
                break;
            case R.id.iv_sc:
                aCache.put("PatentHistory", "");
                rlRecent.setVisibility(View.GONE);
                break;
            case R.id.rl_recent:
                break;
            case R.id.rl_hot:
                break;
            case R.id.ll_rs:
                break;
        }
    }
}
