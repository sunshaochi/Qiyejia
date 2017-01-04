package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 分支机构详情
 * Created by Yang on 2017/1/4 0004.
 */
public class BranchDetailAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_branchdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("分支机构详情");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
    }
}
