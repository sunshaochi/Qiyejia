package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchPatentView extends BaseView {
    //查专利
    void findPatentInfoSucess(String sucessMsg);
    void findPatentInfoFaild(int status,String errorMsg);
    //获取专利类型
    void getPatentTypeSucess(String suceessMsg);
    void getPatentTypeFaild(int status,String errorMsg);
}
