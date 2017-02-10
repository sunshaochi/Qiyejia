package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchPatentPresenter extends BasePresenter {
    //查专利
    void  findPatentInfo(String name, String patenType, String releaseDate, int page, int rows);
    //获取专利类型
    void getPatentType(String type);
    //获取专利热门搜索记录
    void getHotHistory(String type);
}
