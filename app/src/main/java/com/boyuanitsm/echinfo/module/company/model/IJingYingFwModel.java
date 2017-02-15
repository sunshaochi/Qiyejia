package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查找企业，经营范围等
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public interface IJingYingFwModel {
    //查找企业根据企业名
    void getfindStockMsgInfo(String companyName, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback);
    //经营范围查找企业
    void findEnterpriseInfoByBusinessScope(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback);
    //品牌产品查找企业
    void findEnterpriseInfoByProductName(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback);

}
