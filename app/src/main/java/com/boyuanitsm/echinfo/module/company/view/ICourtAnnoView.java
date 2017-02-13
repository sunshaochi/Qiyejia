package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CourtAnnoBean;

import java.util.List;

/**
 * 法院公告
 * Created by wangbin on 17/2/10.
 */
public interface ICourtAnnoView extends BaseView{

    /*查询法院公告*/
    void setCourtAnno(List<CourtAnnoBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
