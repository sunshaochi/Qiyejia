package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 品牌产品
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public interface IPinPaiModel {
    //品牌产品查找企业
    void findEnterpriseInfoByProductName(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback);
    //获取热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
