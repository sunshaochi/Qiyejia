package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 登录
 * Created by Yang on 2016/12/30 0030.
 */
public interface ILoginModel {
    //登录
    void toLogin(String username, String password,ResultCallback callback);
    //把用户插入数据库
    void toAddUser(UserBean userBean);
}
