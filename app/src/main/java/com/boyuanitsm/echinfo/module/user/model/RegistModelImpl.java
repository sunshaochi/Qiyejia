package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * 注册
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public class RegistModelImpl implements IRegistModel {
    @Override
    public void getSmsCaptcha(String phoneNumber, String isRegister, ResultCallback callback) {
        UserManager.getUserManager().getSmscaptcha(phoneNumber,isRegister,callback);
    }

    @Override
    public void toRegister(UserBean user, String captcha,ResultCallback callback) {
        UserManager.getUserManager().toRegister(user,captcha,callback);
    }
}
