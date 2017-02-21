package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IFindBrandPre extends BasePresenter{
    //获取商标热门搜索记录
    void getHotHistory(String type);
}
