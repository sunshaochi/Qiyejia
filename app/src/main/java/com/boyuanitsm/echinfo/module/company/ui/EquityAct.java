package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 股权出资
 * Created by Yang on 2017/1/4 0004.
 */
public class EquityAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_equity;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("股权出资");
    }
}
