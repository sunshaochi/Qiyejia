package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 专利
 * Created by wangbin on 17/2/13.
 */
public class PatentInfoModelImpl implements ICompanyBaseListModel{

    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getPatentById(companyId,resultCallback);
    }
}
