package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.user.model.IRegistModel;
import com.boyuanitsm.echinfo.module.user.model.RegistModelImpl;
import com.boyuanitsm.echinfo.module.user.view.IRegisterView;

/**
 * 注册获取验证码
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public class RegisterPresenterImpl extends BasePresenterImpl<IRegisterView> implements IRegisterPresenter {
    private IRegistModel registModel;
    public RegisterPresenterImpl(IRegisterView view) {
        super(view);
        mView=view;
        registModel=new RegistModelImpl();
    }

    @Override
    public void getSms(String phoneNumber, String isRegister) {
        registModel.getSmsCaptcha(phoneNumber, isRegister, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getSmsFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                String data = response.getData();
                mView.getSmsSucess(data);
            }
        });
    }

    @Override
    public void toRegister(UserBean user, String captcha) {
        registModel.toRegister(user, captcha, new ResultCallback<ResultBean<UserBean>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.toRegisterFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<UserBean> response) {
                UserBean user=new UserBean();
                user=response.getData();
                registModel.toAddUser(user);
                mView.toRegisterSucess(user,response.getMessage());
            }
        });
    }
}
