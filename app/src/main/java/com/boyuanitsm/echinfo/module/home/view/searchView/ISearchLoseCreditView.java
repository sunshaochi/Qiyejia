package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.LoseCreditDatabean;

/**
 * 查失信
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public interface ISearchLoseCreditView extends BaseView{
    //查商标
    void findLoseCreditInfoSucess(LoseCreditDatabean databean);
    void findLoseCreditInfoFaild(int status, String errorMsg);
    void findLoseCreditNoData();
    void findLoseCreditTotal(int totals);
    //获取商标热门搜索记录
    void getHotHistorySucess(LoseCreditDatabean suceessMsg);
    void getHotHistoryFaild(int status, String errorMsg);


}
