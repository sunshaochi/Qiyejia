package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查询法院公告
 * Created by wangbin on 17/2/10.
 */
public interface ICourtAnnoModel {

    void getCourtAnnoList(String companyId, ResultCallback resultCallback);
}
