package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchBrandPresenter extends BasePresenter {
    //查商标
    void  findBrandInfo(String name, String patenType, int page, int rows);
    //获取商标类型
    void getBrandType(String type);

}
