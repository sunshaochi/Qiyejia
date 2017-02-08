package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchPatentModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchPatentModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchPatentView;

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
        searchPatentModel.findPatentInfo(name, patenType, releaseDate, page, rows, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findPatentInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.findPatentInfoSucess(response.getMessage());
            }
        });
    }

    @Override
    public void getPatentType(String type) {

    }
}
