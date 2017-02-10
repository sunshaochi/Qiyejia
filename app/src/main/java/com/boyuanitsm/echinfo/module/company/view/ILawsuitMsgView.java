package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.LawsuitMsgBean;

import java.util.List;

/**
 * 诉讼信息
 * Created by wangbin on 17/2/10.
 */
public interface ILawsuitMsgView extends BaseView{

    void setLawsuitMsg(List<LawsuitMsgBean> datas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
