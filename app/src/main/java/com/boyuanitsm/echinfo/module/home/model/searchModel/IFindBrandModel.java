package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 *
 * 获取商标热搜记录
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IFindBrandModel {

    //获取商标热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
