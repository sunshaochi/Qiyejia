package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.user.model.ForgetPwdModelImpl;
import com.boyuanitsm.echinfo.module.user.model.IForgetPwdModel;
import com.boyuanitsm.echinfo.module.user.view.IForgetPwdView;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class IForgetPwdPresenterImpl extends BasePresenterImpl<IForgetPwdView> implements IForgetPwdPresenter {

    private IForgetPwdModel forgetPwdModel;

    public IForgetPwdPresenterImpl(IForgetPwdView view) {
        super(view);
        mView = view;
        forgetPwdModel = new ForgetPwdModelImpl();
    }

    @Override
    public void getSms(String phoneNumber, String isRegister) {
        forgetPwdModel.getSmsCaptcha(phoneNumber, isRegister, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                    mView.getSmsFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                    mView.getSmsSucess(response.getMessage());
            }
        });
    }

    @Override
    public void resetPwd(String captcha, String phone, String newPwd) {
        forgetPwdModel.resetPwd(captcha, phone, newPwd, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.toResetPwdFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.toResetPwdSucess(response.getMessage());
            }
        });
    }

}
