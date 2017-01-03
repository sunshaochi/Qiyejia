package com.boyuanitsm.echinfo.module.company.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.boyuanitsm.tools.view.indicator.buildins.commonnavigator.titles.CommonPagerTitleView;

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
    private ExecutedPersonFrg frg;
    private FrgPagerAdp adapter;
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
        if (frg == null) {
            frg = ExecutedPersonFrg.newInstance(1);
            frgList.add(frg);
            frg = ExecutedPersonFrg.newInstance(2);
            frgList.add(frg);
        }
        fragmentManager = getSupportFragmentManager();
        adapter = new FrgPagerAdp(fragmentManager,frgList);
        vp_executed.setAdapter(adapter);
        vp_executed.setCurrentItem(0);

        CommonNavigator commonNavigator = new CommonNavigator(getApplicationContext());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                View view = View.inflate(context,R.layout.view_mpagertitle,null);
                final TextView tv_pager_title = (TextView) view.findViewById(R.id.tv_pager_title);
                final ImageView iv_pager_arrow = (ImageView) view.findViewById(R.id.iv_pager_arrow);
                tv_pager_title.setText(title[index]);
                commonPagerTitleView.setContentView(view);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index, int totalCount) {
                        tv_pager_title.setTextColor(Color.parseColor("#2485f2"));
                        iv_pager_arrow.setBackgroundResource(R.mipmap.blue_down_icon);
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        tv_pager_title.setTextColor(Color.parseColor("#333333"));
                        iv_pager_arrow.setBackgroundResource(R.mipmap.black_dowm_icon);
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {

                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {

                    }
                });
                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
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
                return linePagerIndicator;
            }
        });
        mg_title.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mg_title,vp_executed);
    }
}
