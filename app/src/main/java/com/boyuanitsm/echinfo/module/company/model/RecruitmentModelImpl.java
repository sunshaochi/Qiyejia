package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public class RecruitmentModelImpl implements IRecruitmentModel {
    @Override
    public void getRecruitDatas(String companyId, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getRecruitment(companyId,resultCallback);
    }
}
