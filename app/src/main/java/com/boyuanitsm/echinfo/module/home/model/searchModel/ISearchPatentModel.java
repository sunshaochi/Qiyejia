package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchPatentModel {
    //查专利
    void findPatentInfo(String name, String patenType, String releaseDate, int page, int rows, ResultCallback callback);
    //获取专利类型
    void getPatentType(String type,ResultCallback callback);
    //获取专利热门搜索记录
    void getHotHistory(String type,ResultCallback callback);
}
