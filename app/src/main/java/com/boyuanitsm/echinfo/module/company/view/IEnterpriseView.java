package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.EnterpriBean;
import com.boyuanitsm.echinfo.bean.RecruiBean;

import java.util.List;

import butterknife.BindView;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public interface IEnterpriseView extends BaseView {
    /*查询法院公告*/
    void setEnterpri(List<EnterpriBean> mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
