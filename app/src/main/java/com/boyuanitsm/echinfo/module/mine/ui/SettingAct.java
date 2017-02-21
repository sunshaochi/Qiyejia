package com.boyuanitsm.echinfo.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.home.ui.HomeFrg;
import com.boyuanitsm.echinfo.module.home.ui.MainAct;
import com.boyuanitsm.echinfo.module.mine.presenter.LoginOutPreImpl;
import com.boyuanitsm.echinfo.module.mine.view.ILoginOutView;
import com.boyuanitsm.echinfo.utils.ACache;
import com.boyuanitsm.echinfo.utils.SpUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.MyAlertDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 * Created by Yang on 2016/12/29 0029.
 */
public class SettingAct extends BaseAct<LoginOutPreImpl> implements ILoginOutView{
    @BindView(R.id.miv_version)
    MineItemView miv_version;//版本更新
    ACache aCache;
    @Override
    public int getLayout() {
        return R.layout.act_setting;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("设置");
        aCache=ACache.get(SettingAct.this);
        mPresenter=new LoginOutPreImpl(this);
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
                new MyAlertDialog(SettingAct.this).builder().setTitle("提示").setMsg("确认退出吗？").setPositiveButton("退出", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.loginOut();
                    }
                }).setNegativeButton("取消",null).show();
                break;
        }
    }

    @Override
    public void loginOutSucess(String sucessMsg) {
        MyApplication.getInstances().getDaoSession().getUserBeanDao().deleteAll();
        SpUtils.clearSp(getApplicationContext());
        aCache.clear();
        Bundle bundle=new Bundle();
        bundle.putInt(MainAct.EXIT_APP,1);
        openActivity(MainAct.class,bundle);
        sendBroadcast(new Intent(HomeFrg.DATA_UPDATA));
        finish();
    }

    @Override
    public void loginOutFaild(int status, String errorMsg) {
        toast(errorMsg);
    }
}
