package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 行政处罚
 * Created by wangbin on 17/2/10.
 */
public class PunishmentModelImpl implements ICompanyBaseListModel{
    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getAdministrativeDatas(companyId,resultCallback);
    }
}
