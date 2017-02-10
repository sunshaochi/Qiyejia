package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 企业年报
 * Created by wangbin on 17/2/9.
 */
public interface IYearReportModel {

    void getYearReportDatas(String companyId, ResultCallback resultCallback);
}
