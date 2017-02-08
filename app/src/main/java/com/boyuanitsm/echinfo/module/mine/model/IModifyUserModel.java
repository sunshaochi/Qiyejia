package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 修改个人资料代理接口
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IModifyUserModel {
    //修改个人资料
    void modifyUser(UserBean user, ResultCallback callback);
    //修改密码
    void modifyPwd(String password,String newPassword,ResultCallback callback);
}
