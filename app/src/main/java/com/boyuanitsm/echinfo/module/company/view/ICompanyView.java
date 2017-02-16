package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CompanyBean;

/**
 * 公司信息
 * Created by wangbin on 17/2/8.
 */
public interface ICompanyView extends BaseView{
    /*设置公司信息*/
    void setCompanyMes(CompanyBean companyBean);

    void requestError(int status, String errorMsg);

    void addInsertAtt();//添加关注

    void removeAtt();//取消关注



}
