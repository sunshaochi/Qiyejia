package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.YearReportBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.YearReportModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/9.
 */
public class YearReportPreImpl extends BasePresenterImpl<IBaseListView<YearReportBean>> implements ICompanyBasePre {
    private ICompanyBaseListModel model;

    public YearReportPreImpl(IBaseListView<YearReportBean> view) {
        super(view);
        mView = view;
        model = new YearReportModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<YearReportBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<YearReportBean>> response) {
                List<YearReportBean> list=response.getData();
                if(list==null||list.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(list);
                }
            }
        });
    }
}
