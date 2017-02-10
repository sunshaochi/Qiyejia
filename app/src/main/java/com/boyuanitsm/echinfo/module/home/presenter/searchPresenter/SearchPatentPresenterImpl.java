package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.PatentBean;
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
        searchPatentModel.findPatentInfo(name, patenType, releaseDate, page, rows, new ResultCallback<ResultBean<DateBean<PatentBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findPatentInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<PatentBean>> response) {
                List<PatentBean> list=response.getData().getRows();
                mView.findPatentTotal(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findPatentInfoSucess(list);
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
        searchPatentModel.getHotHistory(type, new ResultCallback<ResultBean<List<PatentBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getHotHistoryFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<PatentBean>> response) {
                mView.getHotHistorySucess(response.getData());
            }
        });
    }
}
