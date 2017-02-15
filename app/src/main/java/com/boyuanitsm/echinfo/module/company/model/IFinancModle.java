package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public interface IFinancModle  {
    /*查询融资信息*/
    void getFinancIf(String companyId,ResultCallback resultCallback);//获取融资数据
}
