package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 *实现查询商标接口类
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class SearchLoseCreditModelImpl implements ISearchLoseCreditModel{

    @Override
    public void findLoseCreditInfo(String name, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findLoseCreditInfo(name,page,rows,callback);
    }

    @Override
    public void getHotHistory(String type, ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }
}
