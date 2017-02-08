package com.boyuanitsm.echinfo.module.home.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 可能感兴趣的
 * Created by wangbin on 17/2/8.
 */
public class InterestModelImpl implements IInterestModel{

    @Override
    public void toGetCompany(ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().toGetInterestCompany(resultCallback);
    }
}
