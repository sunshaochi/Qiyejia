package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 返回的List的Base
 * Created by wangbin on 17/2/14.
 */
public interface ICompanyBaseListModel {

    void getDatas(String companyId, ResultCallback resultCallback);
}
