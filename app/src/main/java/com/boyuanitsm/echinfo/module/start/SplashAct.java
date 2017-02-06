package com.boyuanitsm.echinfo.module.start;

import android.os.Bundle;
import android.os.Handler;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.user.ui.LoginAct;

/**
 * 启动页
 * Created by wangbin on 16/12/22.
 */
public class SplashAct extends BaseAct {

    @Override
    public int getLayout() {
        return R.layout.act_splash;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity(LoginAct.class);
                finish();
            }
        }, 0);
    }
}
