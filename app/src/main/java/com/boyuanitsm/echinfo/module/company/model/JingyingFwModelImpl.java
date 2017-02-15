package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 企业查询接口实现类
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public class JingyingFwModelImpl implements IJingYingFwModel{
    @Override
    public void getfindStockMsgInfo(String companyName, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findStockByName(companyName,address,industry,capital,establishDate,page,rows,callback);
    }

    @Override
    public void findEnterpriseInfoByBusinessScope(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findEnterpriseInfoByBusinessScope(businessScope,address,industry,capital,establishDate,page,rows,callback);
    }

    @Override
    public void findEnterpriseInfoByProductName(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findEnterpriseInfoByProductName(businessScope,address,industry,capital,establishDate,page,rows,callback);

    }
}
