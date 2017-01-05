package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 失信公司信息（失信详情）
 * Created by Yang on 2017/1/5 0005.
 */
public class CreditDetailAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_creditdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("失信公司信息");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
    }
}
