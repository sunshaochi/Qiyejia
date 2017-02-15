package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;

import java.util.List;

/**
 * Created by wangbin on 17/2/14.
 */
public interface IBaseListView<T> extends BaseView{

    /*查询法院公告*/
    void setDatas(List<T> mDatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
