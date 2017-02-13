package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 *实现查询判决接口类
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class SearchJudgmentModelImpl implements ISearchJudgmentModel{
    @Override
    public void findJudgmentInfo(String name, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findJudgmentInfo(name,page,rows,callback);
    }

    @Override
    public void getJudgmentType(String type, ResultCallback callback) {
        FindManager.getFindManager().getPatentType(type,callback);
    }

    @Override
    public void getHotHistory(String type, ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }
}
