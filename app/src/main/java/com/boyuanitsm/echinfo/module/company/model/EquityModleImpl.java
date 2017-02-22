package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public class EquityModleImpl implements IEquityModle {
    @Override
    public void getFinancIf(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getEquitylist(companyId,"",resultCallback);
    }
}
