package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by wangbin on 17/2/8.
 */
public class CompanyModelImpl implements ICompanyModel{

    @Override
    public void getCompanyMes(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().toGetCompanyDetail(companyId,resultCallback);
    }
}
