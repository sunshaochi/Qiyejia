package com.boyuanitsm.echinfo.http.manager;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.EchinoUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * Created by wangbin on 17/2/6.
 */
public class UserManager {
    private static UserManager userManager;

    public static UserManager getUserManager() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }


    /**
     * 登录
     *
     * @param username
     * @param password
     * @param resultCallback
     */
    public void toLogin(String username, String password, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        OkHttpManager.getInstance().doPost(EchinoUrl.LOGIN_URL, params, resultCallback);
    }


    /**
     * 获取短信验证码注册
     * @param username
     * @param resultCallback
     */
    public void getSmscaptcha(String username,String isRegist,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("phoneNumber",username);
        params.put("isRegister",isRegist);
        OkHttpManager.getInstance().doPost(EchinoUrl.GET_SMS_URL,params,resultCallback);
    }

    public void toRegister(UserBean user,String captcha,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("username",user.getUsername());
        params.put("phoneNumber",user.getUsername());
        params.put("captcha",captcha);
        OkHttpManager.getInstance().doPost(EchinoUrl.TO_REGISTER_URL,params,resultCallback);
    }

}
