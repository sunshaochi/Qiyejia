package com.boyuanitsm.echinfo.module.user.model;

import com.boyuanitsm.echinfo.callback.RequestCallback;

/**
 * 登录
 * Created by Yang on 2016/12/30 0030.
 */
public interface ILoginModel {
    void toLogin(RequestCallback<String> callback);
}
