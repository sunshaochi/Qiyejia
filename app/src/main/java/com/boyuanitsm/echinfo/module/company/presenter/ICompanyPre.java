package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * Created by wangbin on 17/2/8.
 */
public interface ICompanyPre extends BasePresenter{

    void getCompanyDetail(String companyId);

    void addInsertAtt(String companyId);//添加关注

    void removeAtt(String companyId);//取消关注
}
