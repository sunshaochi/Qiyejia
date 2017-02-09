package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.PatentBean;
import com.boyuanitsm.echinfo.bean.PatentTypeBean;

import java.util.List;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchPatentView extends BaseView {
    //查专利
    void findPatentInfoSucess(List<PatentBean> list);
    void findPatentInfoFaild(int status,String errorMsg);
    void findPatentNoData();
    //获取专利类型
    void getPatentTypeSucess(List<PatentTypeBean> suceessMsg);
    void getPatentTypeFaild(int status,String errorMsg);
}