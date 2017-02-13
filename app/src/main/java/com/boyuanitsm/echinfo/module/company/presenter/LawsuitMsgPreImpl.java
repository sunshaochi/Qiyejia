package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.LawsuitMsgBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ILawsuitMsgModel;
import com.boyuanitsm.echinfo.module.company.model.LawsuitMsgModelImpl;
import com.boyuanitsm.echinfo.module.company.view.ILawsuitMsgView;

import java.util.List;

/**
 * Created by wangbin on 17/2/10.
 */
public class LawsuitMsgPreImpl extends BasePresenterImpl<ILawsuitMsgView> implements ILawsuitMsgPre {

    private ILawsuitMsgModel model;

    public LawsuitMsgPreImpl(ILawsuitMsgView view) {
        super(view);
        mView = view;
        model = new LawsuitMsgModelImpl();
    }

    @Override
    public void getLawsuitMsgDatas(String companyId) {
        model.getLawsuitMsgDatas(companyId, new ResultCallback<ResultBean<List<LawsuitMsgBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<LawsuitMsgBean>> response) {
                List<LawsuitMsgBean> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setLawsuitMsg(datas);
                }
            }
        });
    }
}
