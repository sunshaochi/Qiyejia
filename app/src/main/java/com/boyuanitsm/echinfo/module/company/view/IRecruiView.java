package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CourtAnnoBean;
import com.boyuanitsm.echinfo.bean.RecruiBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public interface IRecruiView extends BaseView {

    /*查询法院公告*/
    void setCourtRecr(List<RecruiBean> mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();

}
