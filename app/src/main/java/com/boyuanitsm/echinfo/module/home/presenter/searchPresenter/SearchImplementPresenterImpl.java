package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.ImplementBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchImplementModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchImplementModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchImplementView;

import java.util.List;

/**
 * 查执行
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public class SearchImplementPresenterImpl extends BasePresenterImpl<ISearchImplementView> implements ISearchImplementPresenter {
    private ISearchImplementModel implementModel;
    public SearchImplementPresenterImpl(ISearchImplementView view) {
        super(view);
        mView=view;
        implementModel=new SearchImplementModelImpl();
    }

    @Override
    public void getImplementInfo(String name, int page, int rows) {
        implementModel.findImplementInfo(name, page, rows, new ResultCallback<ResultBean<DateBean<ImplementBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findImplementInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<ImplementBean>> response) {
                 List<ImplementBean> list = response.getData().getRows();
                mView.findImplementTotal(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findImplementInfoSucess(list);
                }else {
                    mView.findImplementNoData();
                }
            }
        });
    }

    @Override
    public void getHotHistory(String type) {
            implementModel.getHotHistory(type, new ResultCallback<ResultBean<List<ImplementBean>>>() {
                @Override
                public void onError(int status, String errorMsg) {
                    mView.getHotHistoryFaild(status,errorMsg);
                }

                @Override
                public void onResponse(ResultBean<List<ImplementBean>> response) {
                    mView.getHotHistorySucess(response.getData());
                }
            });
    }
}
