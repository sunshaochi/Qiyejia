package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 *实现查询执行接口类
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class SearchImplementModelImpl implements ISearchImplementModel{

    @Override
    public void findImplementInfo(String name, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findImplementInfo(name,page,rows,callback);
    }

    @Override
    public void getHotHistory(String type, ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }
}
