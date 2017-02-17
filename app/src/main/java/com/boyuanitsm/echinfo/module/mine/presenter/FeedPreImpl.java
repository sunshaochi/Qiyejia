package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.mine.model.FeedModle;
import com.boyuanitsm.echinfo.module.mine.model.FeedModleImpl;
import com.boyuanitsm.echinfo.module.mine.view.IFeedView;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public class FeedPreImpl extends BasePresenterImpl<IFeedView>implements IFeedPre {
    private FeedModle modle;
    public FeedPreImpl(IFeedView view) {
        super(view);
        mView=view;
        modle=new FeedModleImpl();
    }

    @Override
    public void Commit(String content, String mobileEmailQqNo) {
        modle.Commti(content, mobileEmailQqNo, new ResultCallback<ResultBean>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requstErroy(status,errorMsg);

            }

            @Override
            public void onResponse(ResultBean response) {
                mView.CommitSuc();

            }
        });

    }
}
