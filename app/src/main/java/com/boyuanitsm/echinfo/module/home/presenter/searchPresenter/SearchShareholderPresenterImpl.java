package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchShareholderModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchShareholderModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchShareholderView;

import java.util.List;

/**
 * 查高管/股东
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public class SearchShareholderPresenterImpl extends BasePresenterImpl<ISearchShareholderView>implements ISearchShareholderPresenter {
    private ISearchShareholderModel model;
    public SearchShareholderPresenterImpl(ISearchShareholderView view) {
        super(view);
        mView=view;
        model=new SearchShareholderModelImpl();
    }

    @Override
    public void getQiYeinfo(String stockMsgName, String address, String industry, String capital, String establishDate, int page, int rows) {
        model.getfindStockMsgInfo(stockMsgName, address, industry, capital, establishDate, page, rows, new ResultCallback<ResultBean<DateBean<CompanyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findEnterpriseInfoByNameFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<CompanyBean>> response) {
                List<CompanyBean> list = response.getData().getRows();
                mView.findEnterpriseTotals(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findEnterpriseInfoByNameSuceess(list);
                }else {
                    mView.findfindEnterpriseInfoByNameNodata();
                }
            }
        });
    }

    @Override
    public void getHotHistory(String type) {
        model.getHotHistory(type, new ResultCallback<ResultBean<List<CompanyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getHotHistoryFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<CompanyBean>> response) {
                mView.getHotHistorySucess(response.getData());
            }
        });
    }
}
