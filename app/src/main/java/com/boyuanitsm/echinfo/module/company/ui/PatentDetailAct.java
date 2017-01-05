package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 专利详情信息
 * Created by Yang on 2017/1/5 0005.
 */
public class PatentDetailAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_patentdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("专利详细信息");
    }
}
