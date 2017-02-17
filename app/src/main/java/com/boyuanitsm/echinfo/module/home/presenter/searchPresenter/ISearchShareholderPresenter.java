package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查高管/股东
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public interface ISearchShareholderPresenter extends BasePresenter{
    //获取企业信息
    void  getQiYeinfo(String stockMsgName, String address, String industry, String capital, String establishDate, int page, int rows);
    //获取专利热门搜索记录
    void getHotHistory(String type);
}
