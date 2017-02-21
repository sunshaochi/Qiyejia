package com.boyuanitsm.echinfo.module.home.ui.search;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.SearchHistoryAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.FindBrandPreImpl;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.IFindBrandPre;
import com.boyuanitsm.echinfo.module.home.view.searchView.IFindBrandView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagClickListener;
import com.boyuanitsm.tools.view.indicator.MagicIndicator;
import com.boyuanitsm.tools.view.indicator.ViewPagerHelper;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.CommonNavigator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class FindBrandAct extends BaseAct<IFindBrandPre> implements IFindBrandView {
    private String[] title = {"近似查询", "精确查询","申请人"};// 0：近似查询、1：精确查询、2：申请人
    private FrgAdapter adapter;
    @BindView(R.id.mg_title)
    MagicIndicator magicIndicator;
    @BindView(R.id.vp_brand)
    ViewPager vp_brand;
    ACache aCache;
    Gson gson;
    List<String> names = new ArrayList<>();
    List<String> hotNames = new ArrayList<>();
    SearchHistoryAdapter<String> recentAdatper;//最近搜索适配器
    SearchHistoryAdapter<String> hotAdapter;//热门搜索适配器


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

    @BindView(R.id.ll_rs)
    LinearLayout llRs;//热门搜索

    @BindView(R.id.rm)
    FlowTagLayout rm;//热门搜索
    @BindView(R.id.iv_sc)
    ImageView ivSc;//最近搜索删除
    String name;
    int page = 1;
    int rows = 10;
    String patentType="0";//0：近似查询、1：精确查询、2：申请人

    @Override
    public int getLayout() {
        return R.layout.frg_find_brand;

    }

    @Override
    public void init(Bundle savedInstanceState) {
        adapter = new FrgAdapter(getSupportFragmentManager());
        mPresenter=new FindBrandPreImpl(this);
        vp_brand.setAdapter(adapter);
        vp_brand.setCurrentItem(0);
        aCache=ACache.get(FindBrandAct.this);
        gson=new Gson();
        //获取热门搜索词语
        mPresenter.getHotHistory("Trademark");
        //填充最近搜索
        initRecentSearch();
        //填充热门搜索
        inithotReSou();
        query.setHint("请输入商标名");
        query.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(getCurrentFocus()
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


        CommonNavigator commonNavigator = new CommonNavigator(FindBrandAct.this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(title[index]);
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#2485f2"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_brand.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setLineHeight(2);
                linePagerIndicator.setColors(Color.parseColor("#2485f2"));
                return linePagerIndicator;    // 没有指示器，因为title的指示作用已经很明显了
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, vp_brand);
    }
    /**
     * 热门搜索
     */
    private void inithotReSou() {
        hotAdapter = new SearchHistoryAdapter<>(getApplication());
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
                Intent intent=new Intent(SearchBrandFrg.BRAND_UPDATA);
                intent.putExtra("name",name);
                sendBroadcast(intent);
//                mPresenter.findBrandInfo(name, patentType,  page, rows);
            }
        });
    }

    /**
     * 最近搜索
     */
    private void initRecentSearch() {
        String strTime = null;
        strTime = aCache.getAsString("BrandHistory");
        if (!TextUtils.isEmpty(strTime)) {
            query.setFocusable(true);
            query.setFocusableInTouchMode(true);
            query.requestFocus();
            llRs.setVisibility(View.VISIBLE);
            rlRecent.setVisibility(View.VISIBLE);
            rlSearch.setVisibility(View.GONE);
            names = gson.fromJson(strTime, new TypeToken<List<String>>() {
            }.getType());

        } else {
            rlSearch.setVisibility(View.VISIBLE);
            rlRecent.setVisibility(View.GONE);
        }
        sizeFlowLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);
        if (recentAdatper==null){
            recentAdatper = new SearchHistoryAdapter<>(FindBrandAct.this);
        }
        sizeFlowLayout.setAdapter(recentAdatper);
        recentAdatper.onlyAddAll(names);
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
                Intent intent=new Intent(SearchBrandFrg.BRAND_UPDATA);
                intent.putExtra("name",name);
                sendBroadcast(intent);
            }
        });

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
            ToolsUtils.hideSoftKeyboard(FindBrandAct.this);
            Intent intent=new Intent(SearchBrandFrg.BRAND_UPDATA);
            intent.putExtra("name",name);
            sendBroadcast(intent);
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


    class FrgAdapter extends FragmentPagerAdapter {

        public FrgAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SearchBrandFrg searchBrandFrg=new SearchBrandFrg();
            Bundle bundle=new Bundle();
            bundle.putString(SearchBrandFrg.INPUT_TYPE,position+"");
            searchBrandFrg.setArguments(bundle);
            return searchBrandFrg;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
    @OnClick({R.id.iv_sc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_sc:
                aCache.put("BrandHistory", "");
                rlRecent.setVisibility(View.GONE);
                break;

        }
    }
}
