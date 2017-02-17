package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.PatenDataBean;
import com.boyuanitsm.echinfo.bean.PatenInfoDataBean;
import com.boyuanitsm.echinfo.bean.PatenInfomationBean;
import com.boyuanitsm.echinfo.bean.PatentTypeBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchPatentModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchPatentModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchPatentView;

import java.util.List;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class SearchPatentPresenterImpl extends BasePresenterImpl<ISearchPatentView> implements ISearchPatentPresenter {
    private ISearchPatentModel searchPatentModel;

    public SearchPatentPresenterImpl(ISearchPatentView view) {
        super(view);
        mView=view;
        searchPatentModel=new SearchPatentModelImpl();
    }

    @Override
    public void findPatentInfo(String name, String patenType, final String releaseDate, int page, int rows) {
        searchPatentModel.findPatentInfo(name, patenType, releaseDate, page, rows, new ResultCallback<ResultBean<PatenDataBean>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findPatentInfoFaild(status,errorMsg);
            }
//            DateBean<PatenInfomationBean>
            @Override
            public void onResponse(ResultBean<PatenDataBean> response) {
                PatenDataBean data = response.getData();
                PatenInfoDataBean patenInfomationList = data.getPatenInfomationList();
                mView.findPatentTotal(patenInfomationList.getTotal());
                if (patenInfomationList.getRows()!=null&&patenInfomationList.getRows().size()>0){
                    mView.findPatentInfoSucess(patenInfomationList.getRows());
                    mView.getRecentYears(data.getReleaseYear());
                }else {
                    mView.findPatentNoData();
                }
            }
        });
    }

    @Override
    public void getPatentType(String type) {
        searchPatentModel.getPatentType(type, new ResultCallback<ResultBean<List<PatentTypeBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getPatentTypeFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<PatentTypeBean>> response) {
            mView.getPatentTypeSucess(response.getData());
            }
        });

    }

    @Override
    public void getHotHistory(String type) {
        searchPatentModel.getHotHistory(type, new ResultCallback<ResultBean<List<PatenInfomationBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getHotHistoryFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<PatenInfomationBean>> response) {
                mView.getHotHistorySucess(response.getData());
            }
        });
    }
}
