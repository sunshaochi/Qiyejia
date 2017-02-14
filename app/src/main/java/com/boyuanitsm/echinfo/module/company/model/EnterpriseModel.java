package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public interface EnterpriseModel {
    void getEnterpriDatas(String companyId,ResultCallback resultCallback);//获取企业资讯
}
