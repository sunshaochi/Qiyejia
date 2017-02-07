package com.boyuanitsm.echinfo.module.user.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.module.home.ui.MainAct;
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

    private String username, pwd;

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
                if (isValidate()) {
                    showProgress("正在登录中...");
                    mPresenter.toLogin(username, pwd);
                }
                break;
        }
    }


    @Override
    public void loginSuccess(UserBean userBean) {
        hideProgress();
        toast("登录成功");

        openActivity(MainAct.class);
        finish();
    }

    /**
     * 失败
     *
     * @param status
     * @param errorMsg
     */
    @Override
    public void loginFailed(int status, String errorMsg) {
        hideProgress();
        toast(errorMsg);
    }


    private boolean isValidate() {
        username = login_phone.getText().toString().trim();
        pwd = login_pwd.getText().toString().toString();
        if (TextUtils.isEmpty(username)) {
            toast("请输入手机号");
            login_phone.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            toast("请输入密码");
            login_pwd.requestFocus();
            return false;
        }
        return true;
    }
}
