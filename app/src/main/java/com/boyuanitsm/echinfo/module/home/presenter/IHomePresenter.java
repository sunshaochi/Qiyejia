package com.boyuanitsm.echinfo.module.home.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * Created by wangbin on 16/12/23.
 */
public interface IHomePresenter extends BasePresenter{

    //我的关注
    void getMyAttention();

    //获取热门企业
    void getHotHistory(String type);
}
