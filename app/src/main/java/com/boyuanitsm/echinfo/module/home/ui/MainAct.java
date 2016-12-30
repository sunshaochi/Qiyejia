package com.boyuanitsm.echinfo.module.home.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.home.view.IMainView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 * Created by wangbin on 16/12/22.
 */
public class MainAct extends BaseAct implements IMainView {
    private FragmentManager fragmentManager;
    private Fragment homeFrg, followFrg, findFrg, mineFrg;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.ivHome)
    ImageView ivHome;
    @BindView(R.id.tvAtten)
    TextView tvAtten;
    @BindView(R.id.ivAtten)
    ImageView ivAtten;
    @BindView(R.id.tvFind)
    TextView tvFind;
    @BindView(R.id.ivFind)
    ImageView ivFind;
    @BindView(R.id.tvMine)
    TextView tvMine;
    @BindView(R.id.ivMine)
    ImageView ivMine;

    @Override
    public int getLayout() {
        return R.layout.act_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        selectTabPosition(0);
    }

    @OnClick({R.id.llHome, R.id.llFollow, R.id.llFind, R.id.llMine})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.llHome://首页
                selectTabPosition(0);
                break;
            case R.id.llFollow:// 关注
                selectTabPosition(1);
                break;
            case R.id.llFind://发现
                selectTabPosition(2);
                break;
            case R.id.llMine://我的
                selectTabPosition(3);
                break;
        }
    }

    @Override
    public void selectTabPosition(int position) {
        setCurrentTab(position);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if(homeFrg==null){
                    homeFrg=new HomeFrg();
                    transaction.add(R.id.frame_main,homeFrg);
                }else {
                    transaction.show(homeFrg);
                }

                break;
            case 1:
                if(followFrg==null){
                    followFrg=new FollowFrg();
                    transaction.add(R.id.frame_main,followFrg);
                }else {
                    transaction.show(followFrg);
                }
                break;
            case 2:
                if(findFrg==null){
                    findFrg=new FindFrg();
                    transaction.add(R.id.frame_main,findFrg);
                }else {
                    transaction.show(findFrg);
                }
                break;
            case 3:
                if(mineFrg==null){
                    mineFrg=new MineFrg();
                    transaction.add(R.id.frame_main,mineFrg);
                }else {
                    transaction.show(mineFrg);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void setCurrentTab(int position) {
        switch (position){
            case 0:
                ivHome.setImageResource(R.mipmap.home_h);
                tvHome.setTextColor(Color.parseColor("#2485f2"));
                ivAtten.setImageResource(R.mipmap.attention);
                tvAtten.setTextColor(Color.parseColor("#666666"));
                ivFind.setImageResource(R.mipmap.find);
                tvFind.setTextColor(Color.parseColor("#666666"));
                ivMine.setImageResource(R.mipmap.me);
                tvMine.setTextColor(Color.parseColor("#666666"));
                break;
            case 1:
                ivHome.setImageResource(R.mipmap.home);
                tvHome.setTextColor(Color.parseColor("#666666"));
                ivAtten.setImageResource(R.mipmap.attention_h);
                tvAtten.setTextColor(Color.parseColor("#2485f2"));
                ivFind.setImageResource(R.mipmap.find);
                tvFind.setTextColor(Color.parseColor("#666666"));
                ivMine.setImageResource(R.mipmap.me);
                tvMine.setTextColor(Color.parseColor("#666666"));
                break;
            case 2:
                ivHome.setImageResource(R.mipmap.home);
                tvHome.setTextColor(Color.parseColor("#666666"));
                ivAtten.setImageResource(R.mipmap.attention);
                tvAtten.setTextColor(Color.parseColor("#666666"));
                ivFind.setImageResource(R.mipmap.find_h);
                tvFind.setTextColor(Color.parseColor("#2485f2"));
                ivMine.setImageResource(R.mipmap.me);
                tvMine.setTextColor(Color.parseColor("#666666"));
                break;
            case 3:
                ivHome.setImageResource(R.mipmap.home);
                tvHome.setTextColor(Color.parseColor("#666666"));
                ivAtten.setImageResource(R.mipmap.attention);
                tvAtten.setTextColor(Color.parseColor("#666666"));
                ivFind.setImageResource(R.mipmap.find);
                tvFind.setTextColor(Color.parseColor("#666666"));
                ivMine.setImageResource(R.mipmap.me_h);
                tvMine.setTextColor(Color.parseColor("#2485f2"));
                break;
        }
    }


    /**
     * 隐藏所有的页面
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFrg != null) {
            transaction.hide(homeFrg);
        }
        if (followFrg != null) {
            transaction.hide(followFrg);
        }
        if (findFrg != null) {
            transaction.hide(findFrg);
        }
        if (mineFrg != null) {
            transaction.hide(mineFrg);
        }

    }
}
