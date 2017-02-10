package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.YearReportBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IYearReportModel;
import com.boyuanitsm.echinfo.module.company.model.YearReportModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IYearReportView;

import java.util.List;

/**
 * Created by wangbin on 17/2/9.
 */
public class YearReportPreImpl extends BasePresenterImpl<IYearReportView> implements IYearReportPre {
    private IYearReportModel model;

    public YearReportPreImpl(IYearReportView view) {
        super(view);
        mView = view;
        model = new YearReportModelImpl();
    }

    @Override
    public void getYearReportDatas(String companyId) {
        model.getYearReportDatas(companyId, new ResultCallback<ResultBean<List<YearReportBean>>>() {
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
                    mView.setYearReport(list);
                }
            }
        });
    }
}
