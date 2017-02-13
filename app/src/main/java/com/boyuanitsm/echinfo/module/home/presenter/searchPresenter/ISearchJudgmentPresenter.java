package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查判决
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public interface ISearchJudgmentPresenter extends BasePresenter{
    //获取查判决信息
    void getJudgmentInfo(String name,  int page, int rows);
    //获取查判决类型
    void getJudgmentType(String type);
    //获取商标热门搜索记录
    void getHotHistory(String type);
}
