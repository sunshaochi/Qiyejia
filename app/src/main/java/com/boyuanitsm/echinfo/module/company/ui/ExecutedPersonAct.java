package com.boyuanitsm.echinfo.module.company.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.home.ui.find.Interestfrg;
import com.boyuanitsm.echinfo.module.home.ui.find.Scanfrg;
import com.boyuanitsm.tools.view.indicator.MagicIndicator;
import com.boyuanitsm.tools.view.indicator.ViewPagerHelper;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.CommonNavigator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.abs.IPagerTitleView;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 被执行人界面
 * Created by Yang on 2017/1/3 0003.
 */
public class ExecutedPersonAct extends BaseAct {
    @BindView(R.id.mg_title)
    MagicIndicator mg_title;
    @BindView(R.id.vp_executed)
    ViewPager vp_executed;

    private String[] title = {"不限状态", "不限时间"};
    private List<Fragment> frgList;
    private Interestfrg interestfrg;
    private Scanfrg scanfrg;
//    private FrgAdapter adapter;
    private FragmentManager fragmentManager;

    @Override
    public int getLayout() {
        return R.layout.act_excutedperson;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("被执行人");
        initFrg();
    }

    private void initFrg() {
        frgList = new ArrayList<>();
        if (interestfrg == null) {
            interestfrg = new Interestfrg();
        }
        frgList.add(interestfrg);
        if (scanfrg == null) {
            scanfrg = new Scanfrg();
        }
        frgList.add(scanfrg);
//        fragmentManager = getFragmentManager();
//        adapter = new FrgAdapter(fragmentManager);
//        vp_executed.setAdapter(adapter);
        vp_executed.setCurrentItem(0);

        CommonNavigator commonNavigator = new CommonNavigator(getApplicationContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                commonPagerTitleView.setContentView(0);
                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        vp_executed.setCurrentItem(index);
                    }
                });
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(title[index]);
                simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#2485f2"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_executed.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setLineHeight(2);
                linePagerIndicator.setColors(Color.parseColor("#2485f2"));
                return linePagerIndicator;    // 没有指示器，因为title的指示作用已经很明显了
            }
        });
        mg_title.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mg_title,vp_executed);
    }
}
