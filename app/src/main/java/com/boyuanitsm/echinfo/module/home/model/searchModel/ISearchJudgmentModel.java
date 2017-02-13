package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 查判决
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public interface ISearchJudgmentModel {
    //查判决
    void findJudgmentInfo(String name,  int page, int rows, ResultCallback callback);
    //获取判决类型
    void getJudgmentType(String type, ResultCallback callback);
    //获取商标热门搜索记录
    void getHotHistory(String type, ResultCallback callback);
}
