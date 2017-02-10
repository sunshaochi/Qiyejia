package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 企业年报获取数据
 * Created by wangbin on 17/2/9.
 */
public class YearReportModelImpl implements IYearReportModel{

    @Override
    public void getYearReportDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().toGetComanyReport(companyId,resultCallback);
    }
}
