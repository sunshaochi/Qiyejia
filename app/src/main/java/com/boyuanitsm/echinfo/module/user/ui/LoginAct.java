package com.boyuanitsm.echinfo.module.user.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.user.presenter.ILoginPresenter;
import com.boyuanitsm.echinfo.module.user.presenter.LoginPresenterImpl;
import com.boyuanitsm.echinfo.module.user.view.ILoginView;
import com.boyuanitsm.tools.AppManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 * Created by wangbin on 16/12/22.
 */
public class LoginAct extends BaseAct<ILoginPresenter> implements ILoginView {
    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_pwd)
    EditText login_pwd;

    @Override
    public int getLayout() {
        return R.layout.act_login;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter = new LoginPresenterImpl(this);
    }

    @OnClick({R.id.tv_toRegister, R.id.tv_toForget, R.id.btn_login})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_toRegister://注册
                AppManager.getAppManager().addActivity(LoginAct.this);
                openActivity(RegisterAct.class);
                break;
            case R.id.tv_toForget://忘记密码
                break;
            case R.id.btn_login://登录
                mPresenter.toLogin("", "");
                break;
        }
    }

    @Override
    public void loginSuccess() {
        finish();
    }
}
