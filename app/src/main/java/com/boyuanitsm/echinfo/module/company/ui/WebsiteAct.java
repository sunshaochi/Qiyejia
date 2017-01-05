package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 注册网站信息
 * Created by Yang on 2017/1/5 0005.
 */
public class WebsiteAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_website;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("网站信息");
    }
}
