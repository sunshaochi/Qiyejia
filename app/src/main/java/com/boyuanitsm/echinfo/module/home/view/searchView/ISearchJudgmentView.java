package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.JudgementBean;

import java.util.List;

/**
 * 查判决
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public interface ISearchJudgmentView extends BaseView{
    //查商标
    void findJudgmentInfoSucess(List<JudgementBean> list);
    void findJudgmentInfoFaild(int status, String errorMsg);
    void findJudgmentNoData();
    void findJudgmentTotal(int totals);
    //获取商标类型
    void getJudgmentTypeSucess(List<JudgementBean> suceessMsg);
    void getJudgmentTypeFaild(int status,String errorMsg);
    //获取商标热门搜索记录
    void getHotHistorySucess(List<JudgementBean> suceessMsg);
    void getHotHistoryFaild(int status, String errorMsg);


}
