package com.boyuanitsm.echinfo.module.home.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CompanyBean;

import java.util.List;

/**
 * 可能感兴趣
 * Created by wangbin on 17/2/7.
 */
public interface IInterestView extends BaseView{

    void setCompanyData(List<CompanyBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();


}
