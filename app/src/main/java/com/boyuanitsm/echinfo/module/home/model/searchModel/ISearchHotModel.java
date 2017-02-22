package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 热门搜索
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public interface ISearchHotModel  {

    //获取商标热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
