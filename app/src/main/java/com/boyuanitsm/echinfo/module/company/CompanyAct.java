package com.boyuanitsm.echinfo.module.company;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.company.ui.ExecutedPersonAct;

/**
 * 公司信息
 * Created by Yang on 2017/1/3 0003.
 */
public class CompanyAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_company;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("公司信息");
    }

    public void openNext(View view) {
        openActivity(ExecutedPersonAct.class);
    }
}
