package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class QiYeZsModelImpl implements IQiyeZsModel {
    @Override
    public void getQiYeList(String companyId, ResultCallback callback) {
        CompanyManager.getCompanyManager().getQiYeList(companyId,callback);
    }
}
