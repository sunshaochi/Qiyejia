package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 动产抵押
 * Created by Yang on 2017/1/3 0003.
 */
public class ChattelMortgageAct extends BaseAct{
    @Override
    public int getLayout() {
        return R.layout.act_chattelmortgage;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("动产抵押");
    }
}
