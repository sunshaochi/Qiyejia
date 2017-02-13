package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查失信
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchLoseCreditPresenter extends BasePresenter {
    //查商标
    void  findLoseCreditInfo(String name, int page, int rows);
    //获取商标热门搜索记录
    void getHotHistory(String type);
}
