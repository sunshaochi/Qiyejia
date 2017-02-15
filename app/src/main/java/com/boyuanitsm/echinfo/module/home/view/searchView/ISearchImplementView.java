package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.ImplementBean;

import java.util.List;

/**
 * 查执行
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public interface ISearchImplementView extends BaseView{
    //查商标
    void findImplementInfoSucess(List<ImplementBean> list);
    void findImplementInfoFaild(int status, String errorMsg);
    void findImplementNoData();
    void findImplementTotal(int totals);
    //获取商标热门搜索记录
    void getHotHistorySucess(List<ImplementBean> suceessMsg);
    void getHotHistoryFaild(int status, String errorMsg);


}
