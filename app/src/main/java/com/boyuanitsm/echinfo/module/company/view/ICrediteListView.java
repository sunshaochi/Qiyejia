package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.LoseCreditDatabean;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public interface ICrediteListView extends BaseView {
    void getCreditListSucess(LoseCreditDatabean databean);
    void findLoseCreditNoData();
    void getCreditListFaild(int status,String errorMsg);
}
