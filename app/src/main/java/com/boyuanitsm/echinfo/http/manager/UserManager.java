package com.boyuanitsm.echinfo.http.manager;

import android.text.TextUtils;

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
     *
     * @param username
     * @param resultCallback
     */
    public void getSmscaptcha(String username, String isRegist, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("phoneNumber", username);
        params.put("isRegister", isRegist);
        OkHttpManager.getInstance().doPost(EchinoUrl.GET_SMS_URL, params, resultCallback);
    }

    /**
     * 注册
     *
     * @param user
     * @param captcha
     * @param resultCallback
     */
    public void toRegister(UserBean user, String captcha, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("phoneNumber", user.getUsername());
        if (!TextUtils.isEmpty(user.getPassword())){
            params.put("password",user.getPassword());
        }
        params.put("captcha", captcha);
        OkHttpManager.getInstance().doPost(EchinoUrl.TO_REGISTER_URL, params, resultCallback);
    }

    /**.
     * 忘记密码
     * @param captcha
     * @param phone
     * @param newPwd
     * @param resultCallback
     */
    public void resetPwd(String captcha, String phone, String newPwd, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("phoneNumber", phone);
        params.put("captcha", captcha);
        params.put("newPassword", newPwd);
        OkHttpManager.getInstance().doPost(EchinoUrl.FORGET_PASSWORD_URL,params,resultCallback);
    }

    /**
     * 修改资料
     * @param user
     * @param resultCallback
     */
    public void modifyUser(UserBean user,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(user.getName())){
            params.put("name",user.getName());
        }
        if (!TextUtils.isEmpty(user.getCompanyName())){
            params.put("companyName",user.getCompanyName());
        }
        if (!TextUtils.isEmpty(user.getJob())){
            params.put("job",user.getJob());
        }
        OkHttpManager.getInstance().doPost(EchinoUrl.MODIFY_USER_URL,params,resultCallback);
    }

    /**
     * 修改密码
     * @param password
     * @param newPassword
     * @param callback
     */
    public void modifyPwd(String password, String newPassword, ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(password)){
            params.put("password",password);
        }
        if (!TextUtils.isEmpty(newPassword)){
            params.put("newPassword",newPassword);
        }
        OkHttpManager.getInstance().doPost(EchinoUrl.MODIFY_PWD_URL,params,callback);
    }

    /**
     * 添加关注
     * @param companyId
     * @param resultCallback
     */
    public void addInsertAtt(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doPost(EchinoUrl.INSERTMYATT_URL,params,resultCallback);
    }

    /**
     * 取消关注
     * @param companyId
     * @param resultCallback
     */
    public void removeAtt(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doPost(EchinoUrl.DELETEMYATT_URL,params,resultCallback);
    }

    /**查询关注列表
     * @param resultCallback
     */
    public void FindMyAtt(ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDMYATT_URL,params,resultCallback);

    }
}
