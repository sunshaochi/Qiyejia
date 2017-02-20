package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.mine.model.ILoginOutModleImpl;
import com.boyuanitsm.echinfo.module.mine.model.IloginOutModle;
import com.boyuanitsm.echinfo.module.mine.view.ILoginOutView;

/**
 * 退出
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public class LoginOutPreImpl extends BasePresenterImpl<ILoginOutView> implements ILoginOutPre {
    private IloginOutModle modle;
    public LoginOutPreImpl(ILoginOutView view) {
        super(view);
        mView=view;
        modle=new ILoginOutModleImpl();
    }

    @Override
    public void loginOut() {
        modle.loginOut(new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.loginOutFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.loginOutSucess(response.getMessage());
            }
        });
    }
}
