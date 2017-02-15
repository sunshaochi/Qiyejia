package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.ClearinfoBean;
import com.boyuanitsm.echinfo.bean.RecruiBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/14.
 */
public interface IClearView extends BaseView {
    /*查询法院公告*/
    void setCourtClear(List<ClearinfoBean> mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
