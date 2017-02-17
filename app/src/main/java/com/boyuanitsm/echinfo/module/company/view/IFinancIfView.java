package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.FinancInfoBean;
import com.boyuanitsm.echinfo.bean.RecruiBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public interface IFinancIfView extends BaseView {
    /*查询融资信息*/
    void setFinancIf(List<FinancInfoBean> mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
