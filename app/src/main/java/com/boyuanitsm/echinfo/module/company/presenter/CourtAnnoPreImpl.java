package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CourtAnnoBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.CourtAnnoModelImpl;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * 法院公告
 * Created by wangbin on 17/2/10.
 */
public class CourtAnnoPreImpl extends BasePresenterImpl<IBaseListView<CourtAnnoBean>> implements ICompanyBasePre {
    private ICompanyBaseListModel model;

    public CourtAnnoPreImpl(IBaseListView<CourtAnnoBean> view) {
        super(view);
        mView = view;
        model = new CourtAnnoModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<CourtAnnoBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<CourtAnnoBean>> response) {
                List<CourtAnnoBean> list = response.getData();
                if (list == null || list.size() == 0) {
                    mView.requestNoData();
                } else {
                    mView.setDatas(list);
                }
            }
        });
    }
}
