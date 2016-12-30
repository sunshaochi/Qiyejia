package com.boyuanitsm.echinfo.module.user.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.tools.AppManager;

/**
 * 注册完成
 * Created by Yang on 2016/12/30 0030.
 */
public class RegisterSuccessAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_registersuccess;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("注册成功");
    }

    public void toHome(View v) {
        AppManager.getAppManager().finishAllActivity();
        finish();
    }
}
