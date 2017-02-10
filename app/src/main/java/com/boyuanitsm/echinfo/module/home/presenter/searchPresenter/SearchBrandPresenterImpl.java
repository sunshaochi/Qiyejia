package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchBrandModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchBrandModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchBrandView;

import java.util.List;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class SearchBrandPresenterImpl extends BasePresenterImpl<ISearchBrandView> implements ISearchBrandPresenter {
    private ISearchBrandModel iSearchBrandModel;
    public SearchBrandPresenterImpl(ISearchBrandView view) {
        super(view);
        mView=view;
        iSearchBrandModel=new SearchBrandModelImpl();
    }

    @Override
    public void findBrandInfo(String name, String patenType, int page, int rows) {
        iSearchBrandModel.findBrandInfo(name, patenType, page, rows, new ResultCallback<ResultBean<DateBean<BrandBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findBrandInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<BrandBean>> response) {
                List<BrandBean> list=response.getData().getRows();
                mView.findBrandTotal(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findBrandInfoSucess(list);
                }else {
                    mView.findBrandNoData();
                }
            }
        });

    }

    @Override
    public void getBrandType(String type) {

    }

    @Override
    public void getHotHistory(String type) {
            iSearchBrandModel.getHotHistory(type, new ResultCallback<ResultBean<List<BrandBean>>>() {
                @Override
                public void onError(int status, String errorMsg) {
                    mView.getHotHistoryFaild(status,errorMsg);
                }

                @Override
                public void onResponse(ResultBean<List<BrandBean>> response) {
                    mView.getHotHistorySucess(response.getData());
                }
            });
    }
}
