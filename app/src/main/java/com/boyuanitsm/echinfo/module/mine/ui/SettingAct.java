package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.home.ui.MainAct;
import com.boyuanitsm.echinfo.utils.SpUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.MyAlertDialog;

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
                new MyAlertDialog(SettingAct.this).builder().setTitle("提示").setMsg("确认推出吗？").setPositiveButton("退出", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyApplication.getInstances().getDaoSession().getUserBeanDao().deleteAll();
                        SpUtils.clearSp(getApplicationContext());
                        Bundle bundle=new Bundle();
                        bundle.putInt(MainAct.EXIT_APP,1);
                        openActivity(MainAct.class,bundle);
                        finish();

                    }
                }).setNegativeButton("取消",null).show();
                break;
        }
    }
}
