package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

/**
 * 意见反馈
 * Created by Yang on 2016/12/29 0029.
 */
public class FeedBackAct extends BaseAct {
    @Override
    public int getLayout() {
        return R.layout.act_feedback;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("意见反馈");
        setRightBtn("提交", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
