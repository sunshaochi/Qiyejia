package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.ErrorBean;

import java.util.List;

/**
 * 纠错
 * Created by Administrator on 2017/2/15.
 */

public interface IErrorListView extends BaseView {
    //获取纠错列表
    void getErrorListSuccess(List<ErrorBean> mDatas);
    void getErrorListFail(int status, String errorMsg);
    void getErrorNoData();
    //提交纠错信息
    void subErrorSuccess();
    void subErrorFail(int status, String errorMsg);
}
