package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Created by wangbin on 17/2/8.
 */
public class CompanyModelImpl implements ICompanyModel{

    /**
     * 获取公司信息
     * @param companyId
     * @param resultCallback
     */
    @Override
    public void getCompanyMes(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().toGetCompanyDetail(companyId,resultCallback);
    }

    /**
     * 添加关注
     * @param companyId
     * @param resultCallback
     */
    @Override
    public void addInsertAtt(String companyId, ResultCallback resultCallback) {
        UserManager.getUserManager().addInsertAtt(companyId,resultCallback);

    }

    /**
     * 取消关注
     * @param companyId
     * @param resultCallback
     */
    @Override
    public void removeAtt(String companyId, ResultCallback resultCallback) {
        UserManager.getUserManager().removeAtt(companyId,resultCallback);
    }
}
