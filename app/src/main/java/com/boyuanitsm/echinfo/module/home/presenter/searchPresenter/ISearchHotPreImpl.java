package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchHotModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchHotModelImpl;
import com.boyuanitsm.echinfo.module.home.view.ISearchHotView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class ISearchHotPreImpl extends BasePresenterImpl<ISearchHotView> implements ISearchHotPre {
    private ISearchHotModel model;

    public ISearchHotPreImpl(ISearchHotView view) {
        super(view);
        mView=view;
        model=new SearchHotModelImpl();
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
                 List<CompanyBean> data = response.getData();
                if (data!=null&&data.size()>0){
                    mView.getHotHistorySucess(data);
                }else {
                    mView.getNodata();
                }
            }
        });
    }
}
