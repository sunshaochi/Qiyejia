package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class MineMsgModleImpl implements IMineMsgModle {
    @Override
    public void upLoadIcon(String path, ResultCallback callback) {
        UserManager.getUserManager().subHeadImg(path,callback);
    }
}
