package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.CrediteListModelImpl;
import com.boyuanitsm.echinfo.module.company.model.ICreditInfoModel;
import com.boyuanitsm.echinfo.module.company.view.ICrediteListView;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public class CrediteListPreImpl extends BasePresenterImpl<ICrediteListView> implements ICreditListPre {
    private ICreditInfoModel model;

    public CrediteListPreImpl(ICrediteListView view) {
        super(view);
        mView=view;
        model=new CrediteListModelImpl();
    }

    @Override
    public void getICrediteByid(String sid) {
        model.getCreditList(sid, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getCreditListFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.getCreditListSucess();
            }
        });
    }
}
