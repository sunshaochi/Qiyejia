package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public interface ICrediteListView extends BaseView {
    void getCreditListSucess();
    void getCreditListFaild(int status,String errorMsg);
}
