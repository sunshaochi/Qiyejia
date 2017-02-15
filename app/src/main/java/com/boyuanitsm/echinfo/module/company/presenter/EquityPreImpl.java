package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.EquityBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.EquityModleImpl;
import com.boyuanitsm.echinfo.module.company.model.IEquityModle;
import com.boyuanitsm.echinfo.module.company.view.IEquityView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public class EquityPreImpl extends BasePresenterImpl<IEquityView> implements IEquityPre {
    private IEquityModle modle;
    public EquityPreImpl(IEquityView view) {
        super(view);
        mView=view;
        modle=new EquityModleImpl();
    }

    @Override
    public void getEquityDatas(String companyId) {
        modle.getFinancIf(companyId, new ResultCallback<ResultBean<List<EquityBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<EquityBean>> response) {
                List<EquityBean>list=response.getData();
                if(list.size()==0||list==null){
                    mView.requestNoData();
                }else {
                    mView.setEquityDatas(list);
                }

            }
        });

    }
}
