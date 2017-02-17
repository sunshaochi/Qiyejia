package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查股东/高管
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public interface ISearchShareholderModel {
    //根据股东或高管查企业
    void getfindStockMsgInfo(String companyName, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback);
    //获取股东/高管热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
