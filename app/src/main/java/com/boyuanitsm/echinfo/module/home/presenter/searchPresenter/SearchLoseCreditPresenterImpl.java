package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.LoseCreditDatabean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchLoseCreditModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchLoseCreditModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchLoseCreditView;

/**
 * 查失信
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public class SearchLoseCreditPresenterImpl extends BasePresenterImpl<ISearchLoseCreditView>implements ISearchLoseCreditPresenter {
    private ISearchLoseCreditModel creditModel;
    public SearchLoseCreditPresenterImpl(ISearchLoseCreditView view) {
        super(view);
        mView=view;
        creditModel=new SearchLoseCreditModelImpl();
    }

    @Override
    public void findLoseCreditInfo(String name, int page, int rows) {
        creditModel.findLoseCreditInfo(name, page, rows, new ResultCallback<ResultBean<LoseCreditDatabean>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findLoseCreditInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<LoseCreditDatabean> response) {
                LoseCreditDatabean data = response.getData();
                if (data!=null){
                    mView.findLoseCreditInfoSucess(data);
                }else {
                    mView.findLoseCreditNoData();
                }
            }
        });
    }

    @Override
    public void getHotHistory(String type) {
            creditModel.getHotHistory(type, new ResultCallback<ResultBean<LoseCreditDatabean>>() {
                @Override
                public void onError(int status, String errorMsg) {
                    mView.getHotHistoryFaild(status,errorMsg);
                }

                @Override
                public void onResponse(ResultBean<LoseCreditDatabean> response) {
                    mView.getHotHistorySucess(response.getData());
                }
            });
    }
}
