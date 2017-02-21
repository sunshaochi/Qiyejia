package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.IconFilePath;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.mine.model.IMineMsgModle;
import com.boyuanitsm.echinfo.module.mine.model.MineMsgModleImpl;
import com.boyuanitsm.echinfo.module.mine.view.IMineMsgView;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class MineMsgPreImpl extends BasePresenterImpl<IMineMsgView> implements MineMsgPre{
    private IMineMsgModle modle;
    public MineMsgPreImpl(IMineMsgView view) {
        super(view);
        mView=view;
        modle=new MineMsgModleImpl();
    }



    @Override
    public void upLoadIcon(String path) {
        modle.upLoadIcon(path, new ResultCallback<ResultBean<IconFilePath>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.upLoadHeadFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<IconFilePath> response) {
                mView.upLoadHeadSucess(response.getMessage());
            }
        });
    }
}
