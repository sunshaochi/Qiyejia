package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.mine.model.ModifyUserModelImpl;
import com.boyuanitsm.echinfo.module.mine.view.IModifyUserView;

/**
 * 修改个人信息
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class ModifyUserPresenterImpl extends BasePresenterImpl<IModifyUserView> implements IModifyUserPresenter  {
    private ModifyUserModelImpl modifyUserModel;
    public ModifyUserPresenterImpl(IModifyUserView view) {
        super(view);
        mView=view;
        modifyUserModel=new ModifyUserModelImpl();
    }

    @Override
    public void modifyUser(UserBean user) {
        modifyUserModel.modifyUser(user, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.modifyUserFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.modifyUserSucess(response.getMessage());
            }
        });

    }

    @Override
    public void modifyPwd(String password, String newPassword) {
        modifyUserModel.modifyPwd(password, newPassword, new ResultCallback<ResultBean<String>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.modifyPwdFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<String> response) {
                mView.modifyPwdSucess(response.getMessage());
            }
        });
    }
}
