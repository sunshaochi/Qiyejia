package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 企业获取的通用接口
 * Created by wangbin on 17/2/14.
 */
public interface ICompanyBasePre extends BasePresenter{

    void getDatas(String companyId);
}
