package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 忘记密码
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IForgetPwdModel {
    //获取短信验证码
    void getSmsCaptcha(String phoneNumber, String isRegister, ResultCallback callback);
    //忘记密码
    void resetPwd(String captcha, String phone, String newPwd,ResultCallback callback);
}
