package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 对外投资接口
 * Created by wangbin on 17/2/9.
 */
public interface IForengnInvesModel {
    /*获取对外投资列表*/
    void getForengnInvesData(String companyId, ResultCallback resultCallback);
}
