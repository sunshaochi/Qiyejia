package com.boyuanitsm.echinfo.module.home.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.module.home.model.IMineModel;
import com.boyuanitsm.echinfo.module.home.view.IMineView;

/**
 * Created by wangbin on 17/2/7.
 */
public class MinePresenterImpl extends BasePresenterImpl implements IMinePresenter{
    private IMineModel iMineModel;
    public MinePresenterImpl(IMineView view) {
        super(view);
        mView=view;
//        iMineModel=new MinePresenterImpl();
    }

    @Override
    public void getUser() {

    }
}
