package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 诉讼信息
 * Created by wangbin on 17/2/10.
 */
public interface ILawsuitMsgModel {

    void getLawsuitMsgDatas(String companyId, ResultCallback resultCallback);
}
