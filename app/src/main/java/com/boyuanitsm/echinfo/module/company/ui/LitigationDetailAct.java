package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 诉讼详情
 * Created by Yang on 2017/1/5 0005.
 */
public class LitigationDetailAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_lgdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("诉讼详细信息");
    }
}
