package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CourtAnnoBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.CourtAnnoModelImpl;
import com.boyuanitsm.echinfo.module.company.model.ICourtAnnoModel;
import com.boyuanitsm.echinfo.module.company.view.ICourtAnnoView;

import java.util.List;

/**
 * 法院公告
 * Created by wangbin on 17/2/10.
 */
public class CourtAnnoPreImpl extends BasePresenterImpl<ICourtAnnoView> implements ICourtAnnoPre {
    private ICourtAnnoModel model;

    public CourtAnnoPreImpl(ICourtAnnoView view) {
        super(view);
        mView = view;
        model = new CourtAnnoModelImpl();
    }

    @Override
    public void getCourtAnnoDatas(String companyId) {
        model.getCourtAnnoList(companyId, new ResultCallback<ResultBean<List<CourtAnnoBean>>>() {
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
                    mView.setCourtAnno(list);
                }
            }
        });
    }
}
