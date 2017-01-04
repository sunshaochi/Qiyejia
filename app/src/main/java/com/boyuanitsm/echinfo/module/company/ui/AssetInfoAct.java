package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 企业资产信息
 * Created by Yang on 2017/1/4 0004.
 */
public class AssetInfoAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_assetinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("企业资产信息");
    }
}
