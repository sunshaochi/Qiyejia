package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查执行
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchImplementModel {
    //查执行
    void findImplementInfo(String name, int page, int rows, ResultCallback callback);
    //获取商标热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
