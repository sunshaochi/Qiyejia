package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by bitch-1 on 2017/2/22.
 */
public interface IWebsiteModle {

    void getData(String companyId, ResultCallback resultCallback);
}
