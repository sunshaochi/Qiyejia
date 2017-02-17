package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;


/**
 * Created by bitch-1 on 2017/2/15.
 */
public interface IFinancingInfoPre extends BasePresenter {
    /*查询融资信息*/
    void getFinancIf(String companyId);//获取融资数据

}
