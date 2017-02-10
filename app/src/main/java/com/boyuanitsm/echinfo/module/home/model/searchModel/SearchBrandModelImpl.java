package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 *实现查询商标接口类
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class SearchBrandModelImpl implements ISearchBrandModel{
    @Override
    public void findBrandInfo(String name, String type, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().getBrandInfo(name,type,page,rows,callback);
    }

    @Override
    public void getBrandType(String type, ResultCallback callback) {
        FindManager.getFindManager().getPatentType(type,callback);
    }

    @Override
    public void getHotHistory(String type, ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }
}
