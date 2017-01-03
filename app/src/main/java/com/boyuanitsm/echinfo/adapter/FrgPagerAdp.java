package com.boyuanitsm.echinfo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * fragment页面适配器
 * Created by Yang on 2017/1/3 0003.
 */
public class FrgPagerAdp extends FragmentPagerAdapter {
    private List<Fragment> frgList;
    public FrgPagerAdp(FragmentManager fm, List<Fragment> frgList) {
        super(fm);
        this.frgList = frgList;
    }

    @Override
    public Fragment getItem(int position) {
        return frgList.get(position);
    }

    @Override
    public int getCount() {
        return frgList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
