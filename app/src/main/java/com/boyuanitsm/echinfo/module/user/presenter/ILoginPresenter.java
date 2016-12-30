package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 登录
 * Created by Yang on 2016/12/30 0030.
 */
public interface ILoginPresenter extends BasePresenter{
    void toLogin(String mobile,String pwd);
}
