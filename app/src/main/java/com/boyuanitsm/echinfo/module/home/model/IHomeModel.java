package com.boyuanitsm.echinfo.module.home.model;

import com.boyuanitsm.echinfo.callback.RequestCallback;

/**
 * 首页数据接口代理类
 * Created by wangbin on 16/12/23.
 */
public interface IHomeModel{

    /*获取我的关注*/
    void getMyAttention(RequestCallback<String> callback);
    /*获取热门企业*/
    void getHotCompany(RequestCallback<String> callback);
    /*获取失信列表*/
    void getDishonesty(RequestCallback<String> callback);

}
