package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class IForgetPwdImpl implements IForgetPwdModel {
    @Override
    public void getSmsCaptcha(String phoneNumber, String isRegister, ResultCallback callback) {
        UserManager.getUserManager().getSmscaptcha(phoneNumber,isRegister,callback);
    }
}
