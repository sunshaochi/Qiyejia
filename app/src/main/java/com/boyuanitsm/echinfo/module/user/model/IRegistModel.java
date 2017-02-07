package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 注册代理接口
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public interface IRegistModel {
    //获取短信验证码
    void getSmsCaptcha(String phoneNumber, String isRegister, ResultCallback callback);
    //注册接口调用
    void toRegister(UserBean user,String captcha,ResultCallback callback );
}
