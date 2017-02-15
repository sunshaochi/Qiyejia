package com.boyuanitsm.echinfo.module.company.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.FrgPagerAdp;
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
 * 著作权
 * Created by Yang on 2017/1/4 0004.
 */
public class CopyrightAct extends BaseAct {
    @BindView(R.id.mg_title)
    MagicIndicator mg_title;
    @BindView(R.id.vp_copyright)
    ViewPager vp_copyright;

    private String[] title = {"原创著作权", "软件著作权"};
    private OriginalRightFrg originalRightFrg;
    private SoftwareRightFrg softwareRightFrg;
    private List<Fragment> frgList;
    private FrgPagerAdp adapter;
    private FragmentManager fragmentManager;

    public static  String companyId;

    @Override
    public int getLayout() {
        return R.layout.act_copyright;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("著作权");
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        initFrg();
    }

    private void initFrg() {
        frgList = new ArrayList<>();
        if (originalRightFrg == null) {
            originalRightFrg = new OriginalRightFrg();
            frgList.add(originalRightFrg);
        }
        if (softwareRightFrg == null) {
            softwareRightFrg = new SoftwareRightFrg();
            frgList.add(softwareRightFrg);
        }
        fragmentManager = getSupportFragmentManager();
        adapter = new FrgPagerAdp(fragmentManager, frgList);
        vp_copyright.setAdapter(adapter);
        vp_copyright.setCurrentItem(0);

        CommonNavigator commonNavigator = new CommonNavigator(getApplicationContext());
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
                simplePagerTitleView.setNormalColor(Color.parseColor("#333333"));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#2485f2"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_copyright.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setLineHeight(2);
                linePagerIndicator.setColors(Color.parseColor("#2485f2"));
                return linePagerIndicator;
            }
        });
        mg_title.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mg_title, vp_copyright);
    }
}
