package com.boyuanitsm.echinfo.module.user.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.tools.AppManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by Yang on 2016/12/30 0030.
 */
public class RegisterAct extends BaseAct {
    @BindView(R.id.register_phone)
    EditText register_phone;
    @BindView(R.id.register_code)
    EditText register_code;
    @BindView(R.id.register_pwd)
    EditText register_pwd;
    @BindView(R.id.tv_getCode)
    TextView tv_getCode;

    @Override
    public int getLayout() {
        return R.layout.act_register;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("注册");
    }

    @OnClick({R.id.tv_getCode, R.id.btn_register, R.id.ll_xy})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_getCode://获取验证码
                break;
            case R.id.btn_register://完成注册
                AppManager.getAppManager().addActivity(RegisterAct.this);
                openActivity(RegisterSuccessAct.class);
                break;
            case R.id.ll_xy://服务协议
                break;
        }
    }
}
