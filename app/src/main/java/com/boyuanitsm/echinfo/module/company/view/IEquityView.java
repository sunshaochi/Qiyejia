package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.EquityBean;
import com.boyuanitsm.echinfo.bean.FinancInfoBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public interface IEquityView extends BaseView {
    void setEquityDatas(List<EquityBean> mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
