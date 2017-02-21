package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.FindBrandModelImpl;
import com.boyuanitsm.echinfo.module.home.model.searchModel.IFindBrandModel;
import com.boyuanitsm.echinfo.module.home.view.searchView.IFindBrandView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class FindBrandPreImpl extends BasePresenterImpl<IFindBrandView> implements IFindBrandPre {
    private IFindBrandModel model;
    public FindBrandPreImpl(IFindBrandView view) {
        super(view);
        mView=view;
        model=new FindBrandModelImpl();
    }

    @Override
    public void getHotHistory(String type) {
        model.getHotHistory(type, new ResultCallback<ResultBean<List<BrandBean>>>() {
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
