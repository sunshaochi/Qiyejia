package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.UBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.user.model.ILoginModel;
import com.boyuanitsm.echinfo.module.user.model.LoginModelImpl;
import com.boyuanitsm.echinfo.module.user.view.ILoginView;

/**
 * 登录
 * Created by Yang on 2016/12/30 0030.
 */
public class LoginPresenterImpl extends BasePresenterImpl<ILoginView, String> implements ILoginPresenter {
    private ILoginView mView;
    private ILoginModel loginModel;

    public LoginPresenterImpl(ILoginView view) {
        super(view);
        mView = view;
        loginModel = new LoginModelImpl();
    }

    @Override
    public void toLogin(String username, String password) {
        loginModel.toLogin(username, password, new ResultCallback<ResultBean<UBean>>() {
            @Override
            public void onError(int status, String errorMsg) {
                 mView.loginFailed( status,  errorMsg);
            }

            @Override
            public void onResponse(ResultBean<UBean> response) {
                mView.loginSuccess();
            }
        });

    }
}
