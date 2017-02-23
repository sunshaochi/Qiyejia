package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/22.
 */
public class IWebsiteModleImpl implements IWebsiteModle {
    @Override
    public void getData(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().Findweb(companyId,"",resultCallback);
    }
}
