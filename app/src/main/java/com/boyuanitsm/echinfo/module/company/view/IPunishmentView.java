package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.AdministrativePenaltyBean;

import java.util.List;

/**
 * 行政处罚
 * Created by wangbin on 17/2/10.
 */
public interface IPunishmentView extends BaseView{
    void setPunishmentDatas(List<AdministrativePenaltyBean> mDatas);

    void requestError(int status, String errorMsg);

    void requestNoData();

}
