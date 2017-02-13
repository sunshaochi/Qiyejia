package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by wangbin on 17/2/10.
 */
public class CourtAnnoModelImpl implements ICourtAnnoModel{

    @Override
    public void getCourtAnnoList(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getCourtAnno(companyId,resultCallback);
    }
}
