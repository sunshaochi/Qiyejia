package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.YearReportBean;

import java.util.List;

/**
 * 企业年报
 * Created by wangbin on 17/2/9.
 */
public interface IYearReportView extends BaseView{
    /*查询对外投资列表*/
    void setYearReport(List<YearReportBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
