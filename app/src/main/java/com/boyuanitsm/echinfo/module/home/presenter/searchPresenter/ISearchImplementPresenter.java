package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查执行
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public interface ISearchImplementPresenter extends BasePresenter{
    //获取查判决信息
    void getImplementInfo(String name, int page, int rows);
    //获取商标热门搜索记录
    void getHotHistory(String type);
}
