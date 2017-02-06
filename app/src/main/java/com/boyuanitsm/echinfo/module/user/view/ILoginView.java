package com.boyuanitsm.echinfo.module.user.view;


import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * 登录接口管理类
 * Created by wangbin on 16/12/22.
 */
public interface ILoginView extends BaseView {

    void loginSuccess(UserBean userBean);
    void loginFailed(int status, String errorMsg);
}
