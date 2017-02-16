package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.ProductBean;

import java.util.List;

/**
 * 企业查询
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public interface IPinPaiView extends BaseView {
    //根据企业名字查找企业
    void findEnterpriseInfoByNameSuceess(List<ProductBean> list);
    void findEnterpriseInfoByNameFaild(int status, String errorMsg);
    void findfindEnterpriseInfoByNameNodata();
    void findEnterpriseTotals(int tatal);
    //获取企业热门搜索
    void getHotHistorySucess(List<ProductBean> suceessMsg);
    void getHotHistoryFaild(int status, String errorMsg);
}
