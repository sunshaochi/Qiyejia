package com.boyuanitsm.echinfo.module.home.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.module.home.ui.find.Interestfrg;
import com.boyuanitsm.echinfo.module.home.ui.find.Scanfrg;
import com.boyuanitsm.tools.view.indicator.MagicIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.CommonNavigator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 * Created by wangbin on 16/12/22.
 */
public class FindFrg extends BaseFrg {

    private String[] title = {"可能感兴趣", "推荐阅读"};
    private ViewPager vp_find;
    private List<Fragment> frglist;
    private Interestfrg interestfrg;
    private Scanfrg scanfrg;
    private FrgAdapter adapter;
    private FragmentManager fragmentManager;
    @Override
    public int getLayout() {
        return R.layout.frg_find;

    }

    @Override
    protected void initView(View fragmentRootView) {
        final MagicIndicator magicIndicator = (MagicIndicator) fragmentRootView.findViewById(R.id.mg_title);
        vp_find = (ViewPager) fragmentRootView.findViewById(R.id.vp_find);
        frglist = new ArrayList<>();
        if (interestfrg == null) {
            interestfrg = new Interestfrg();

        }
        frglist.add(interestfrg);
        if (scanfrg == null) {
            scanfrg = new Scanfrg();
        }
        frglist.add(scanfrg);
        fragmentManager = getFragmentManager();
        adapter = new FrgAdapter(fragmentManager);
        vp_find.setAdapter(adapter);
        vp_find.setCurrentItem(0);
        /***
         * vp监听
         */
        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        };
        vp_find.setOnPageChangeListener(listener);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
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
    }
    class FrgAdapter extends FragmentPagerAdapter {

        public FrgAdapter(FragmentManager fm) {
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
