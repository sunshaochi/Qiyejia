package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 法院判决
 * Created by wangbin on 17/2/10.
 */
public interface ICourdecModel {

    void getCourdecDatas(String companyId, ResultCallback resultCallback);
}
