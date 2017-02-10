package com.boyuanitsm.echinfo.module.company.ui;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
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
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagSelectListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**经营范围act
 * Created by bitch-1 on 2017/2/7.
 */

public class JinyinFwAct extends BaseAct {
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

    private List<String> testList = new ArrayList<>();
    private BaseRecyclerAdapter<String> mAdp;
    private PopupWindow mPopupWindow;
    private GvAdapter gvclnxadt, gvzcziadt;
    private TagAdapter<String> mSizeTagAdapter;


    @Override
    public int getLayout() {
        return R.layout.act_jinyinfw;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        initFrg();//初识化下拉刷洗控件
        gvclnxadt = new GvAdapter(JinyinFwAct.this);//成立年限
        gvzcziadt = new GvAdapter(JinyinFwAct.this);//注册资本
    }

    /**
     * 初始化下拉刷新
     */
    private void initFrg() {
        View view = View.inflate(getApplicationContext(), R.layout.xhead, null);
        view.setMinimumWidth(ToolsUtils.getScreenWidth(JinyinFwAct.this));
        xr.addHeaderView(view);
        testList = EchinfoUtils.getTestDatas(3);
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), true);
        xr.setPullRefreshEnabled(false);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_serch;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xr.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xr.loadMoreComplete();

            }
        });
        xr.setAdapter(mAdp);
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
     * @param i
     */
    private void setPopupWindow(int i) {
        if (i == 3) {
            View v = LayoutInflater.from(JinyinFwAct.this).inflate(R.layout.gd_sec, null);
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
            mSizeTagAdapter = new TagAdapter<>(JinyinFwAct.this);//流逝布局
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

        } else if (i == 1) {
            View v = LayoutInflater.from(JinyinFwAct.this).inflate(R.layout.city_sec, null);
            ListView lsv_pricive= (ListView) v.findViewById(R.id.lsv_provice);
            final ListView lsv_city= (ListView) v.findViewById(R.id.lsv_city);
            ProAdapter proadapteer=new ProAdapter(JinyinFwAct.this);
            CityAdapter cityadapter=new CityAdapter(JinyinFwAct.this);
            lsv_pricive.setAdapter(proadapteer);
            lsv_city.setAdapter(cityadapter);

            lsv_pricive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    lsv_city.setVisibility(View.VISIBLE);
                }
            });

            mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);


        } else if (i == 2) {

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


}

