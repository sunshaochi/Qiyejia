package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 实现查专利接口类
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class SearchPatentModelImpl implements ISearchPatentModel {
    @Override
    public void findPatentInfo(String name, String patenType, String releaseDate, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findPatenInfoByName(name,patenType,releaseDate,page,rows,callback);
    }

    @Override
    public void getPatentType(String type, ResultCallback callback) {
        FindManager.getFindManager().getPatentType(type,callback);
    }
}
