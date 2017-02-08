package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class ForgetPwdModelImpl implements IForgetPwdModel {
    @Override
    public void getSmsCaptcha(String phoneNumber, String isRegister, ResultCallback callback) {
        UserManager.getUserManager().getSmscaptcha(phoneNumber,isRegister,callback);
    }

    @Override
    public void resetPwd(String captcha, String phone, String newPwd, ResultCallback callback) {
        UserManager.getUserManager().resetPwd(captcha,phone,newPwd,callback);
    }
}
