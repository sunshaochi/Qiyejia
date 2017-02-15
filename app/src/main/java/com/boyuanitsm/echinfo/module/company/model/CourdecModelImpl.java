package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 法院判决
 * Created by wangbin on 17/2/10.
 */
public class CourdecModelImpl implements ICompanyBaseListModel{

    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getCourtAdjudication(companyId,resultCallback);
    }
}
