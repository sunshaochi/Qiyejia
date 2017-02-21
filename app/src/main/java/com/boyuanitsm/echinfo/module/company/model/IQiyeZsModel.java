package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 企业证书列表接口
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IQiyeZsModel  {
    void getQiYeList(String companyId , ResultCallback callback);
}
