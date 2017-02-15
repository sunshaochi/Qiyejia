package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/14.
 */
public class IClearModelImpl implements IClearModel {
    @Override
    public void getClearinfoDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().geFindclearinfo(companyId,resultCallback);
    }
}
