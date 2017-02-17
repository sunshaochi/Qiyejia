package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IJingYingFwModel;
import com.boyuanitsm.echinfo.module.company.model.JingyingFwModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IJingyingView;

import java.util.List;

/**
 * 根据名字查询企业
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public class JingYingPreImpl extends BasePresenterImpl<IJingyingView> implements IJingYingPre {
    private IJingYingFwModel model;
    public JingYingPreImpl(IJingyingView view) {
        super(view);
        mView=view;
        model=new JingyingFwModelImpl();
    }

    @Override
    public void getQiYeinfo(String companyName, String address, String industry, String capital, String establishDate, boolean isRangeQuery, String screeningRange, int page, int rows) {
        model.getfindStockMsgInfo(companyName, address, industry, capital, establishDate,isRangeQuery,screeningRange, page, rows, new ResultCallback<ResultBean<DateBean<CompanyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findEnterpriseInfoByNameFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<CompanyBean>> response) {
                List<CompanyBean> list = response.getData().getRows();
                mView.findEnterpriseTotals(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findEnterpriseInfoByNameSuceess(list);
                }else {
                    mView.findfindEnterpriseInfoByNameNodata();
                }
            }
        });
    }

    @Override
    public void getQiYeinfobyJyFw(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows) {
        model.findEnterpriseInfoByBusinessScope(businessScope, address, industry, capital, establishDate, page, rows, new ResultCallback<ResultBean<DateBean<CompanyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findEnterpriseInfoByNameFaild(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<CompanyBean>> response) {
                List<CompanyBean> list = response.getData().getRows();
                mView.findEnterpriseTotals(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findEnterpriseInfoByNameSuceess(list);
                }else {
                    mView.findfindEnterpriseInfoByNameNodata();
                }

            }
        });
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
                mView.getHotHistorySucess(response.getData());
            }
        });
    }

}
