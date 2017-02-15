package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 软件著作权
 * Created by wangbin on 17/2/14.
 */
public class SoftwareRightModelImpl implements ICompanyBaseListModel{


    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getSoftwarerightsById(companyId,resultCallback);
    }
}
