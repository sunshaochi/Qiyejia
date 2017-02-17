package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public class FeedModleImpl implements FeedModle {
    @Override
    public void Commti(String content, String mobileEmailQqNo, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().CommitIdeaTicking(content,mobileEmailQqNo,resultCallback);
    }
}
