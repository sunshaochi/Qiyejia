package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by wangbin on 17/2/8.
 */
public interface ICompanyModel {
    /**
     * 获取公司信息
     * @param companyId
     * @param resultCallback
     */
    void getCompanyMes(String companyId, ResultCallback resultCallback);

    void addInsertAtt(String companyId,ResultCallback resultCallback);//添加关注

    void removeAtt(String companyId,ResultCallback resultCallback);//取消关注


}
