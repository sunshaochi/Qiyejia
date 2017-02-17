package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.FinancInfoBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IFinancModle;
import com.boyuanitsm.echinfo.module.company.model.IFinancModleImpl;
import com.boyuanitsm.echinfo.module.company.view.IFinancIfView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public class IFinancingInfoPreImpl extends BasePresenterImpl<IFinancIfView>implements IFinancingInfoPre {
   private IFinancModle modle;
    public IFinancingInfoPreImpl(IFinancIfView view) {
        super(view);
        mView=view;
        modle=new IFinancModleImpl();
    }

    @Override
    public void getFinancIf(String companyId) {
        modle.getFinancIf(companyId, new ResultCallback<ResultBean<List<FinancInfoBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<FinancInfoBean>> response) {
                List<FinancInfoBean>list=response.getData();
                if(list.size()==0||list==null){
                    mView.requestNoData();
                }else {
                    mView.setFinancIf(list);
                }

            }
        });

    }
}
