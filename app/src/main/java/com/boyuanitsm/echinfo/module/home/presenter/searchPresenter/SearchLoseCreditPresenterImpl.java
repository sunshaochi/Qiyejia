package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.LoseCreditBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchLoseCreditModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchLoseCreditModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchLoseCreditView;

import java.util.List;

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
        creditModel.findLoseCreditInfo(name, page, rows, new ResultCallback<ResultBean<DateBean<LoseCreditBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findLoseCreditInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<LoseCreditBean>> response) {
                 List<LoseCreditBean> list = response.getData().getRows();
                if (list!=null&&list.size()>0){
                    mView.findLoseCreditInfoSucess(list);
                }else {
                    mView.findLoseCreditNoData();
                }
            }
        });
    }

    @Override
    public void getHotHistory(String type) {
            creditModel.getHotHistory(type, new ResultCallback<ResultBean<List<LoseCreditBean>>>() {
                @Override
                public void onError(int status, String errorMsg) {
                    mView.getHotHistoryFaild(status,errorMsg);
                }

                @Override
                public void onResponse(ResultBean<List<LoseCreditBean>> response) {
                    mView.getHotHistorySucess(response.getData());
                }
            });
    }
}
