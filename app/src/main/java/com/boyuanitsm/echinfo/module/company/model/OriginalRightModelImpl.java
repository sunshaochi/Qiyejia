package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * 获取著作
 * Created by wangbin on 17/2/14.
 */
public class OriginalRightModelImpl implements ICompanyBaseListModel{

    @Override
    public void getDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getCopyrightsById(companyId,resultCallback);
    }
}
