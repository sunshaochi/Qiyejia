package com.boyuanitsm.echinfo.module.home.model.searchModel;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 查股东/高管
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public class SearchShareholderModelImpl implements ISearchShareholderModel {
    @Override
    public void getfindStockMsgInfo(String companyName, String address, String industry, String capital, String establishDate, int page, int rows, ResultCallback callback) {
        FindManager.getFindManager().findStockMsgInfo(companyName,address,industry,capital,establishDate,page,rows,callback);
    }

    @Override
    public void getHotHistory(String type, ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }
}
