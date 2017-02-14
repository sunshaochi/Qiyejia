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
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.CityAdapter;
import com.boyuanitsm.echinfo.adapter.GvAdapter;
import com.boyuanitsm.echinfo.adapter.ProAdapter;
import com.boyuanitsm.echinfo.adapter.TagAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.presenter.IJingYingPre;
import com.boyuanitsm.echinfo.module.company.presenter.JingYingPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IJingyingView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagSelectListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 经营范围act
 * Created by bitch-1 on 2017/2/7.
 */

public class PinpaidocAct extends BaseAct<IJingYingPre> implements IJingyingView,OnItemClickListener {
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
    int page=1;
    int rows=10;
    @Override
    public int getLayout() {
        return R.layout.act_jinyinfw;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        type = getIntent().getIntExtra(SEARCH_TYPE, 0);
        mPresenter=new JingYingPreImpl(this);
        initFrg();//初识化下拉刷洗控件
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(PinpaidocAct.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    search();
                }
                return false;
            }
        });
        gvclnxadt = new GvAdapter(PinpaidocAct.this);//成立年限
        gvzcziadt = new GvAdapter(PinpaidocAct.this);//注册资本
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
            ToolsUtils.hideSoftKeyboard(PinpaidocAct.this);
            mPresenter.getQiYeinfobyPinPai(name,address,industry,capital,establishDate,page,rows);
        }

    }
    /**
     * 初始化下拉刷新
     */
    private void initFrg() {
        xr = EchinfoUtils.getLinearRecyclerView(xr, this, true);
        mAdp = new BaseRecyclerAdapter<CompanyBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_serch_name;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_person).setText("公司法人："+item.getLegalPerson());
                holder.getTextView(R.id.tv_status).setText("商标/产品："+item.getTrademarkNum());

            }
        };

        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getQiYeinfobyPinPai(name,address,industry,capital,establishDate,page,rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getQiYeinfobyPinPai(name,address,industry,capital,establishDate,page,rows);

            }
        });
        xr.setAdapter(mAdp);
        mAdp.setOnItemClickListener(this);
    }

    @OnClick({R.id.gd_sec, R.id.city_sec, R.id.hy_sec})
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
            View v = LayoutInflater.from(PinpaidocAct.this).inflate(R.layout.gd_sec, null);
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
            mSizeTagAdapter = new TagAdapter<>(PinpaidocAct.this);//流逝布局
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
            View v = LayoutInflater.from(PinpaidocAct.this).inflate(R.layout.city_sec, null);
            ListView lsv_pricive = (ListView) v.findViewById(R.id.lsv_provice);
            final ListView lsv_city = (ListView) v.findViewById(R.id.lsv_city);
            ProAdapter proadapteer = new ProAdapter(PinpaidocAct.this);
            CityAdapter cityadapter = new CityAdapter(PinpaidocAct.this);
            lsv_pricive.setAdapter(proadapteer);
            lsv_city.setAdapter(cityadapter);

            lsv_pricive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    lsv_city.setVisibility(View.VISIBLE);
                }
            });

            mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);


        } else if (i == 2) {//不限行业
            View v = LayoutInflater.from(PinpaidocAct.this).inflate(R.layout.city_sec, null);
            ListView lsv_pricive = (ListView) v.findViewById(R.id.lsv_provice);
            final ListView lsv_city = (ListView) v.findViewById(R.id.lsv_city);
            ProAdapter proadapteer = new ProAdapter(PinpaidocAct.this);
            CityAdapter cityadapter = new CityAdapter(PinpaidocAct.this);
            lsv_pricive.setAdapter(proadapteer);
            lsv_city.setAdapter(cityadapter);

            lsv_pricive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    lsv_city.setVisibility(View.VISIBLE);
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
        if (page==1){
            xr.refreshComplete();
            datas.clear();
        }
        xr.loadMoreComplete();
        if (list!=null&&list.size()>0){
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
    public void onItemClick(View view, int position) {
        Bundle bundle=new Bundle();
        bundle.putString(CompanyAct.COMAPYT_ID,datas.get(position).getId());
        openActivity(CompanyAct.class,bundle);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}

