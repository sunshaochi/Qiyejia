package com.boyuanitsm.echinfo.module.company.ui;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.ConstantValue;
import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.CityAdapter;
import com.boyuanitsm.echinfo.adapter.GvAdapter;
import com.boyuanitsm.echinfo.adapter.ProAdapter;
import com.boyuanitsm.echinfo.adapter.SearchHistoryAdapter;
import com.boyuanitsm.echinfo.adapter.TagAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.presenter.IJingYingPre;
import com.boyuanitsm.echinfo.module.company.presenter.JingYingPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IJingyingView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.GsonUtils;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagClickListener;
import com.boyuanitsm.tools.view.FlowTag.OnTagSelectListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 经营范围act
 * Created by bitch-1 on 2017/2/7.
 */

public class JingyingFwAct extends BaseAct<IJingYingPre> implements IJingyingView {
    @BindView(R.id.xr)
    XRecyclerView xr;//下拉刷新view
    @BindView(R.id.gd_sec)
    LinearLayout gd_sec;//更多
    @BindView(R.id.city_sec)
    LinearLayout city_sec;//城市
    @BindView(R.id.hy_sec)
    LinearLayout hy_sec;//城市
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.tv_hy)
    TextView tv_hy;
    @BindView(R.id.tv_gd)
    TextView tv_gd;
    @BindView(R.id.iv_city)
    ImageView iv_city;
    @BindView(R.id.iv_hy)
    ImageView iv_hy;
    @BindView(R.id.iv_gd)
    ImageView iv_gd;
    @BindView(R.id.query)
    ClearEditText query;
    @BindView(R.id.ll_jg)
    LinearLayout llJg;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.rl_recent)
    RelativeLayout rlRecent;//最近搜索
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;//无搜索记录展示
    @BindView(R.id.ll_rcv)
    LinearLayout ll_rcv;//专利结果展示
    @BindView(R.id.iv_sc)
    ImageView ivSc;//最近搜索删除
    @BindView(R.id.rm)
    FlowTagLayout rm;//热门搜索
    @BindView(R.id.rl_patent)
    RelativeLayout rl_patent;//专利
    @BindView(R.id.ll_rs)
    LinearLayout llRs;//热门搜索
    @BindView(R.id.size_flow_layout)
    FlowTagLayout sizeFlowLayout;//最近搜索流式布局
    private List<CompanyBean> datas = new ArrayList<>();
    private BaseRecyclerAdapter<CompanyBean> mAdp;
    private PopupWindow mPopupWindow;
    private GvAdapter gvclnxadt, gvzcziadt;
    private TagAdapter<String> mSizeTagAdapter;
    public static final String SEARCH_TYPE = "type";
    private int type;
    String name;
    String address;
    String industry;
    String capital;
    String establishDate;
    int page = 1;
    int rows = 10;
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    List<String> hotNames = new ArrayList<>();
    SearchHistoryAdapter<String> recentAdatper;//最近搜索适配器
    SearchHistoryAdapter<String> hotAdapter;//热门搜索适配器
    String[] strYears={"不限","1年内","1-2年内","2-3年内","3-5年内","5-10年内","10年以上"};
    String[] strMoney={"不限","100万以内","100-200万","200-500万","500-1000万","1000万以上"};
    @Override
    public int getLayout() {
        return R.layout.act_jinyinfw;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        type = getIntent().getIntExtra(SEARCH_TYPE, 0);
        mPresenter = new JingYingPreImpl(this);
        aCache=ACache.get(JingyingFwAct.this);
        gson=new Gson();
        initFrg();//初识化下拉刷洗控件
        query.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId== EditorInfo.IME_ACTION_SEARCH){
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(JingyingFwAct.this.getCurrentFocus()
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
        mPresenter.getHotHistory("EnterpriseInfo");
        inithotReSou();
        initRecentSearch();
        String strTime = null;
        strTime = aCache.getAsString("JingYingHistory");
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
        gvclnxadt = new GvAdapter(JingyingFwAct.this,strYears);//成立年限
        gvzcziadt = new GvAdapter(JingyingFwAct.this,strMoney);//注册资本
    }

    /**
     * 最近搜索
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
                mPresenter.getQiYeinfobyJyFw(name, address, industry, capital, establishDate, page, rows);
            }
        });
        String strTime = null;
        strTime = aCache.getAsString("JingYingHistory");
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
            ToolsUtils.hideSoftKeyboard(JingyingFwAct.this);
            mPresenter.getQiYeinfobyJyFw(name, address, industry, capital, establishDate, page, rows);
        }

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
                mPresenter.getQiYeinfobyJyFw(name, address, industry, capital, establishDate, page, rows);
            }
        });
    }

    /**
     * 初始化下拉刷新
     */
    private void initFrg() {
        query.setHint("请输入公司名/地址/经营项目/商标");
//        View view = View.inflate(getApplicationContext(), R.layout.xhead, null);
//        view.setMinimumWidth(ToolsUtils.getScreenWidth(JingyingFwAct.this));
//        xr.addHeaderView(view);
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<CompanyBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_serch;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_person).setText("公司法人：" + item.getLegalPerson());
                holder.getTextView(R.id.tv_fw).setText("经营范围：" + item.getBusinessScope());
                holder.getTextView(R.id.tv_status).setText(item.getManagementStatus());

            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
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
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getQiYeinfobyJyFw(name, address, industry, capital, establishDate, page, rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getQiYeinfobyJyFw(name, address, industry, capital, establishDate, page, rows);

            }
        });
        xr.setAdapter(mAdp);
    }

    @OnClick({R.id.gd_sec, R.id.city_sec, R.id.hy_sec,R.id.iv_sc,R.id.rl_search,R.id.ll_rs})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.gd_sec:
                updatacolor(tv_gd, iv_gd, 0);//变色
                setPopupWindow(3);//展示更多筛选的界面

                break;
            case R.id.city_sec:
                setPopupWindow(1);
                updatacolor(tv_city, iv_city, 0);
                break;

            case R.id.hy_sec:
                setPopupWindow(2);
                updatacolor(tv_hy, iv_hy, 0);
                break;
            case R.id.iv_sc:
                aCache.put("JingYingHistory", "");
                rlRecent.setVisibility(View.GONE);
                break;
            case R.id.rl_search:
                break;
            case R.id.ll_rs:
                break;

        }
    }


    /**
     * 当头部筛选里面空间第一次被点击时候变换颜色
     *
     * @param
     * @param
     * @param type 0表示变成绿色 1表示默认色
     */
    private void updatacolor(TextView tv, ImageView iv, int type) {
        if (type == 0) {//全部变色
            tv.setTextColor(Color.parseColor("#2485f2"));
            iv.setImageResource(R.mipmap.sjtxx);
        }
        if (type == 1) {//全部默认颜色
            tv.setTextColor(Color.parseColor("#333333"));
            iv.setImageResource(R.mipmap.xj);
        }

    }

    /**
     * 设置弹出框
     *
     * @param i
     */
    private void setPopupWindow(int i) {
        if (i == 3) {
            View v = LayoutInflater.from(JingyingFwAct.this).inflate(R.layout.gd_sec, null);
            MyGridView gv_cnlx = (MyGridView) v.findViewById(R.id.gv_clnx);
            MyGridView gv_zczb = (MyGridView) v.findViewById(R.id.gv_zczb);
            FlowTagLayout mSizeFlowTagLayout = (FlowTagLayout) v.findViewById(R.id.size_flow_layout);
            gv_cnlx.setAdapter(gvclnxadt);
            gv_zczb.setAdapter(gvzcziadt);
            gv_cnlx.setSelector(new ColorDrawable(Color.TRANSPARENT));
            gv_zczb.setSelector(new ColorDrawable(Color.TRANSPARENT));
            gv_cnlx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    gvclnxadt.setSeclection(i);
                    gvclnxadt.notifyDataSetChanged();
                }
            });

            gv_zczb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    gvzcziadt.setSeclection(i);
                    gvzcziadt.notifyDataSetChanged();
                }
            });
            mSizeTagAdapter = new TagAdapter<>(JingyingFwAct.this);//流逝布局
            mSizeFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);//设置是单选
            mSizeFlowTagLayout.setAdapter(mSizeTagAdapter);
            mSizeFlowTagLayout.setOnTagSelectListener(new OnTagSelectListener() {
                @Override
                public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {

                }
            });

            List<String> sdatasource = new ArrayList<>();
            sdatasource.add("按名称查");
            sdatasource.add("按地址查");
            sdatasource.add("按经营范围查");
            sdatasource.add("按品牌/产品查");
            sdatasource.add("按法定代表人查");
            mSizeTagAdapter.onlyAddAll(sdatasource);

            mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);

        } else if (i == 1) {//城市
            View v = LayoutInflater.from(JingyingFwAct.this).inflate(R.layout.city_sec, null);
            ListView lsv_pricive = (ListView) v.findViewById(R.id.lsv_provice);
            final ListView lsv_city = (ListView) v.findViewById(R.id.lsv_city);
            final ProAdapter proadapteer = new ProAdapter(JingyingFwAct.this, ConstantValue.getIndustyList(),0);
            lsv_pricive.setAdapter(proadapteer);

            lsv_pricive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (ConstantValue.getIndustyMap().get(ConstantValue.getIndustyList().get(i)) != null) {
                        proadapteer.setSlectionChange(i);
                        CityAdapter cityadapter = new CityAdapter(JingyingFwAct.this, ConstantValue.getIndustyMap().get(ConstantValue.getIndustyList().get(i)));
                        lsv_city.setVisibility(View.VISIBLE);
                        lsv_city.setAdapter(cityadapter);
                    }
                }
            });

            mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);


        } else if (i == 2) {//不限行业
            View v = LayoutInflater.from(JingyingFwAct.this).inflate(R.layout.city_sec, null);
            ListView lsv_pricive = (ListView) v.findViewById(R.id.lsv_provice);
            final ListView lsv_city = (ListView) v.findViewById(R.id.lsv_city);
           final ProAdapter proadapteer = new ProAdapter(JingyingFwAct.this,ConstantValue.getIndustyList(),0);
            lsv_pricive.setAdapter(proadapteer);

            lsv_pricive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (ConstantValue.getIndustyMap().get(ConstantValue.getIndustyList().get(i)) != null) {
                        proadapteer.setSlectionChange(i);
                        CityAdapter cityadapter = new CityAdapter(JingyingFwAct.this, ConstantValue.getIndustyMap().get(ConstantValue.getIndustyList().get(i)));
                        lsv_city.setVisibility(View.VISIBLE);
                        lsv_city.setAdapter(cityadapter);
                    }
                }
            });

            mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);

        }

        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        mPopupWindow.setFocusable(true);
        //获取xoff
        WindowManager manager = (WindowManager) getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);
        int xpos = manager.getDefaultDisplay().getWidth() / 2 - mPopupWindow.getWidth() / 2;
        //xoff,yoff基于anchor的左下角进行偏移。
        mPopupWindow.showAsDropDown(gd_sec);

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                updatacolor(tv_gd, iv_gd, 1);
                updatacolor(tv_city, iv_city, 1);
                updatacolor(tv_hy, iv_hy, 1);
            }
        });


    }

    @Override
    public void findEnterpriseInfoByNameSuceess(List<CompanyBean> list) {
        ToolsUtils.hideSoftKeyboard(JingyingFwAct.this);
        rlSearch.setVisibility(View.GONE);
        llJg.setVisibility(View.VISIBLE);
        ll_rcv.setVisibility(View.VISIBLE);
        String strTime = null;
        strTime = aCache.getAsString("JingYingHistory");
        if (!TextUtils.isEmpty(strTime)) {
            List<String> nameNews = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());
            if (!nameNews.contains(name)) {
                nameNews.add(name);
                aCache.put("JingYingHistory", GsonUtils.bean2Json(nameNews));
                recentAdatper.onlyAddAll(nameNews);
            }
        } else {
            List<String> nameNews = new ArrayList<>();
            nameNews.add(name);
            aCache.put("JingYingHistory", GsonUtils.bean2Json(nameNews));
            recentAdatper.onlyAddAll(nameNews);
        }


        if (page == 1) {
            xr.refreshComplete();
            datas.clear();
        }
        xr.loadMoreComplete();
        if (list != null && list.size() > 0) {
            datas.addAll(list);
        }
        mAdp.setData(datas);

    }


    @Override
    public void findEnterpriseInfoByNameFaild(int status, String errorMsg) {

    }

    @Override
    public void findfindEnterpriseInfoByNameNodata() {

    }

    @Override
    public void findEnterpriseTotals(int tatal) {
        if (tatal>0){
            llJg.setVisibility(View.VISIBLE);
            tvNum.setText(tatal+"");
        }else {
            llJg.setVisibility(View.GONE);
        }
    }

    @Override
    public void getHotHistorySucess(List<CompanyBean> suceessMsg) {
        if (hotNames != null && hotNames.size() > 0) {
            hotNames.clear();
        }
        if (suceessMsg != null && suceessMsg.size() > 0) {
            for (int i = 0; i < suceessMsg.size(); i++) {
                hotNames.add(suceessMsg.get(i).getCompanyName());
            }
            hotAdapter.onlyAddAll(hotNames);
        }
    }

    @Override
    public void getHotHistoryFaild(int status, String errorMsg) {
        toast(errorMsg);
    }


}

