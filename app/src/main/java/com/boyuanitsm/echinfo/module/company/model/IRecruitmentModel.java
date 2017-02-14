package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public interface IRecruitmentModel {
    void getRecruitDatas(String companyId, ResultCallback resultCallback);
}
