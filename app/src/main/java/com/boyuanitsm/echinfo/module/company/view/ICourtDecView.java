package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CourtDecisionBean;

import java.util.List;

/**
 * 法院判决
 * Created by wangbin on 17/2/10.
 */
public interface ICourtDecView extends BaseView{

    void getCourtDecDatas(List<CourtDecisionBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
