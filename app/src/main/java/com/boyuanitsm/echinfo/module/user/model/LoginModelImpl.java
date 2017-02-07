package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * 登录接口
 * Created by Yang on 2016/12/30 0030.
 */
public class LoginModelImpl implements ILoginModel{

    @Override
    public void toLogin(String username, String password,ResultCallback callback) {
        UserManager.getUserManager().toLogin(username,password,callback);
    }

    @Override
    public void toAddUser(UserBean userBean) {
        MyApplication.getInstances().getDaoSession().getUserBeanDao().insert(userBean);
    }
}
