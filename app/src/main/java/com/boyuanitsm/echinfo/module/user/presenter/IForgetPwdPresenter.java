package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 忘记密码
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IForgetPwdPresenter extends BasePresenter {
    void getSms(String phoneNumber,String isRegister);
    void resetPwd(String captcha, String phone, String newPwd);
}
