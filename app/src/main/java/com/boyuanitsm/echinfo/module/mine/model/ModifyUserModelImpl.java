package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class ModifyUserModelImpl implements IModifyUserModel {
    @Override
    public void modifyUser(UserBean user, ResultCallback callback) {
        UserManager.getUserManager().modifyUser(user,callback);
    }

    @Override
    public void modifyPwd(String password, String newPassword, ResultCallback callback) {
        UserManager.getUserManager().modifyPwd(password,newPassword,callback);
    }
}
