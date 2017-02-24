package com.boyuanitsm.echinfo.module.company.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.tools.view.indicator.MagicIndicator;
import com.boyuanitsm.tools.view.indicator.ViewPagerHelper;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.CommonNavigator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 点击评论数目后金进到的界面
 * Created by bitch-1 on 2017/2/24.
 */
public class MorePinrunAct extends BaseAct {
    @BindView(R.id.mg_title)
    MagicIndicator magicIndicator;
    @BindView(R.id.vp_find)
    ViewPager vp_find;

    private String[] title = {"全部评论", "我的评论"};

    private List<Fragment> frglist;
    private FragmentManager fragmentmanager;
    private FraAdapter adapter;

    private QuanPinFragment qpfragment;//全部评论fragment
    private MyPinFragment myPinFragment;//我的评论

    @Override
    public int getLayout() {
        return R.layout.act_morepinrun;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("公司评论");
        frglist = new ArrayList<>();
        if (qpfragment == null) {//全部评论
            qpfragment = new QuanPinFragment();

        }
        frglist.add(qpfragment);
        if (myPinFragment == null) {//我的评论
            myPinFragment = new MyPinFragment();
        }
        frglist.add(myPinFragment);
//        fragmentmanager = getSupportFragmentManager();
//        vp_find.setAdapter(adapter);
        fragmentmanager=getSupportFragmentManager();
        vp_find.setAdapter(adapter);
        vp_find.setCurrentItem(0);

        CommonNavigator commonNavigator = new CommonNavigator(MorePinrunAct.this);
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
                        vp_find.setCurrentItem(index);
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
        ViewPagerHelper.bind(magicIndicator, vp_find);

    }


    class FraAdapter extends FragmentPagerAdapter {
        public FraAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frglist.get(position);
        }

        @Override
        public int getCount() {
            return frglist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
