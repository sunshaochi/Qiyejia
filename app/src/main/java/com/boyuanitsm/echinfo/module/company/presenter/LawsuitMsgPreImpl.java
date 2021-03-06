package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.LawsuitMsgBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.LawsuitMsgModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/10.
 */
public class LawsuitMsgPreImpl extends BasePresenterImpl<IBaseListView<LawsuitMsgBean>> implements ICompanyBasePre {

    private ICompanyBaseListModel model;

    public LawsuitMsgPreImpl(IBaseListView<LawsuitMsgBean> view) {
        super(view);
        mView = view;
        model = new LawsuitMsgModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<LawsuitMsgBean>>>() {
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
                    mView.setDatas(datas);
                }
            }
        });
    }
}
