package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;
import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * 更新用户信息
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IModifyUserPresenter extends BasePresenter {
    void  modifyUser(UserBean user);
    void  modifyPwd(String password,String newPassword);
}
