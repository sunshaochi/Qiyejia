package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 对外投资
 * Created by wangbin on 17/2/9.
 */
public class ForengnInvesImpl implements ICompanyBaseListModel{
    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().toGetInves(companyId,"",resultCallback);
    }
}
