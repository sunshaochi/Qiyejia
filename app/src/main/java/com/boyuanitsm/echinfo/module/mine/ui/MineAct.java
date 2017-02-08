package com.boyuanitsm.echinfo.module.mine.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的界面
 * Created by Yang on 2016/12/27 0027.
 */
public class MineAct extends BaseAct{
    @BindView(R.id.civ_head)
    CircleImageView civ_head;//头像
    @BindView(R.id.miv_phone)
    MineItemView miv_phone;//电话
    @BindView(R.id.miv_changePwd)
    MineItemView miv_changePwd;//改密码
    @BindView(R.id.miv_name)
    MineItemView miv_name;//姓名
    @BindView(R.id.miv_company)
    MineItemView miv_company;//公司
    @BindView(R.id.miv_profession)
    MineItemView miv_profession;//职业
    UserBean userBean;
    @Override
    public int getLayout() {
        return R.layout.act_mine;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("修改资料");
        userBean=new UserBean();
        userBean = EchinfoUtils.getCurrentUser();
        //填充个人资料
        initData(userBean);
    }

    /**
     * 填充个人资料
     * @param userBean
     */
    private void initData(UserBean userBean) {
        if (!TextUtils.isEmpty(userBean.getIcon())){

        }
        if (!TextUtils.isEmpty(userBean.getPhone())){
            miv_phone.setLeftText(userBean.getPhone());
        }
        if (!TextUtils.isEmpty(userBean.getName())){
            miv_name.setRightText(userBean.getName());
        }
        if (!TextUtils.isEmpty(userBean.getCompanyName())){
            miv_company.setRightText(userBean.getCompanyName());
        }
        if (!TextUtils.isEmpty(userBean.getJob())){
            miv_profession.setRightText(userBean.getJob());
        }
    }

    @OnClick({R.id.ll_head, R.id.miv_phone, R.id.miv_changePwd, R.id.miv_name, R.id.miv_company
            , R.id.miv_profession})
    public void OnClick(View v) {
        Bundle bundle;
        switch (v.getId()) {
            case R.id.ll_head://头像
                
                break;
            case R.id.miv_phone:
                break;
            case R.id.miv_changePwd:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,1);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_name:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,2);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_company:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,3);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_profession:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,4);
                openActivity(EditAct.class,bundle);
                break;
        }
    }
    private MyReceiver myReceiver;
    public static final String USER_INFO = "com.update.userinfo";

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            userBean = EchinfoUtils.getCurrentUser();
            initData(userBean);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        getKnowSomebody();//获取可能认识的人列表
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
            registerReceiver(myReceiver, new IntentFilter(USER_INFO));
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }

}
