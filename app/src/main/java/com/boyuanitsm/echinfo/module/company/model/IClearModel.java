package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by bitch-1 on 2017/2/14.
 */
public interface IClearModel {

    void getClearinfoDatas(String companyId, ResultCallback resultCallback);//获取招聘数据
}
