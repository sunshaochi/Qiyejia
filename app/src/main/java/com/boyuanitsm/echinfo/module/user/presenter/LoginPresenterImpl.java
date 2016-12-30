package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.callback.RequestCallback;
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
    public void toLogin(String mobile, String pwd) {
        mView.loginSuccess();
        loginModel.toLogin(new RequestCallback<String>() {
            @Override
            public void beforeRequest() {

            }

            @Override
            public void requestError(String msg) {

            }

            @Override
            public void requestComplete() {

            }

            @Override
            public void requestSuccess(String data) {

            }
        });
    }
}
