package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CompanyBean;

import java.util.List;

/**
 * 对外投资
 * Created by wangbin on 17/2/9.
 */
public interface IForeignInvesView extends BaseView{

    /*查询对外投资列表*/
    void getInvesData(List<CompanyBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();


}
