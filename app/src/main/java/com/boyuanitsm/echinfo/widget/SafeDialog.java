package com.boyuanitsm.echinfo.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by wangbin on 16/11/1.
 */
public class SafeDialog extends ProgressDialog{
    Activity mParentActivity;
    public SafeDialog(Context context)
    {
        super(context);
        mParentActivity = (Activity) context;
    }

    @Override
    public void dismiss()
    {
        if (mParentActivity != null && !mParentActivity.isFinishing())
        {
            super.dismiss();    //调用超类对应方法
        }
    }

}
