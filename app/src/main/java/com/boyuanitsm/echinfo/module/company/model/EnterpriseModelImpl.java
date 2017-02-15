package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public class EnterpriseModelImpl implements EnterpriseModel {

    @Override
    public void getEnterpriDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getEnterpriseNews(companyId,resultCallback);
    }
}
