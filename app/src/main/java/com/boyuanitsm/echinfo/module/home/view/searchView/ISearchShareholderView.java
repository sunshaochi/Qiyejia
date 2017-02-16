package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.StockMsgBean;

import java.util.List;

/**
 * 查股东/高管
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public interface ISearchShareholderView extends BaseView {
    //根据
    void findEnterpriseInfoByNameSuceess(List<StockMsgBean> list);
    void findEnterpriseInfoByNameFaild(int status, String errorMsg);
    void findfindEnterpriseInfoByNameNodata();
    void findEnterpriseTotals(int tatal);
    //获取专利热门搜索记录
    void getHotHistorySucess(List<StockMsgBean> suceessMsg);
    void getHotHistoryFaild(int status,String errorMsg);
}
