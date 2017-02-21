package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.QiYeZsBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IQiYeZsView extends BaseView {
    void getQiYeZsListSucess(List<QiYeZsBean> sucessMsg);
    void getQiYeZsListFaild(int status,String errorMsg);

    void getQiYeNOdata();
}
