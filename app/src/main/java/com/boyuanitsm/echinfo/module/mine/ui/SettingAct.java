package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MineItemView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 * Created by Yang on 2016/12/29 0029.
 */
public class SettingAct extends BaseAct {
    @BindView(R.id.miv_version)
    MineItemView miv_version;//版本更新

    @Override
    public int getLayout() {
        return R.layout.act_setting;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("设置");
    }

    @OnClick({R.id.miv_version, R.id.miv_share, R.id.miv_exit})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.miv_version://版本更新
                break;
            case R.id.miv_share://分享
                openActivity(ShareDialogAct.class);
                break;
            case R.id.miv_exit://退出
                break;
        }
    }
}
