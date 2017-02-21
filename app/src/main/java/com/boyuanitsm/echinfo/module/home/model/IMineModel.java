package com.boyuanitsm.echinfo.module.home.model;

import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * Created by wangbin on 17/2/7.
 */
public interface IMineModel {
    /*获取用户*/
    UserBean toGetUserBean();
    //上传用户头像
    void loadHeadIcon();
}
