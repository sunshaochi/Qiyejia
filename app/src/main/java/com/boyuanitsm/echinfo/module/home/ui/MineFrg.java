package com.boyuanitsm.echinfo.module.home.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.module.home.presenter.MinePresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.IMineView;
import com.boyuanitsm.echinfo.module.mine.ui.FeedBackAct;
import com.boyuanitsm.echinfo.module.mine.ui.FollowAct;
import com.boyuanitsm.echinfo.module.mine.ui.MineAct;
import com.boyuanitsm.echinfo.module.mine.ui.MsgAct;
import com.boyuanitsm.echinfo.module.mine.ui.SettingAct;
import com.boyuanitsm.echinfo.module.user.ui.LoginAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 * Created by wangbin on 16/12/22.
 */
public class MineFrg extends BaseFrg implements IMineView{
    @BindView(R.id.civ_head)
    CircleImageView civ_head;//头像
    @BindView(R.id.tv_name)
    TextView tv_name;//姓名
    @BindView(R.id.tv_profession)
    TextView tv_profession;//职业
    @BindView(R.id.tv_company)
    TextView tv_company;//公司
    @BindView(R.id.miv_gz)
    MineItemView miv_gz;//关注
    @BindView(R.id.miv_xx)
    MineItemView miv_xx;//消息
    @BindView(R.id.miv_fk)
    MineItemView miv_fk;//意见反馈
    @BindView(R.id.miv_wt)
    MineItemView miv_wt;//常见问题
    @BindView(R.id.miv_sz)
    MineItemView miv_sz;//设置
    UserBean user;
    @Override
    public int getLayout() {
        return R.layout.frg_mine;
    }

    @Override
    protected void initView(View fragmentRootView) {
         mPresenter=new MinePresenterImpl(this);
        ((MinePresenterImpl)mPresenter).getUser();
    }

    @OnClick({R.id.ll_mine, R.id.miv_gz, R.id.miv_xx, R.id.miv_fk, R.id.miv_wt, R.id.miv_sz})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.ll_mine://个人资料
                openActivity(MineAct.class);
                break;
            case R.id.miv_gz://关注
                openActivity(FollowAct.class);
                break;
            case R.id.miv_xx://消息
                openActivity(MsgAct.class);
                break;
            case R.id.miv_fk://意见反馈
                openActivity(FeedBackAct.class);
                break;
            case R.id.miv_wt://问题
                openActivity(LoginAct.class);//目前作为登录测试
                break;
            case R.id.miv_sz://设置
                openActivity(SettingAct.class);
                break;
        }
    }

    @Override
    public void showUser(UserBean userBean) {
        tv_company.setText(userBean.getCompanyName());
        tv_name.setText(userBean.getName());
        tv_profession.setText(userBean.getJob());
    }
    private MyReceiver myReceiver;
    public static final String USER_INFO = "com.mine.userinfo";

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            user = EchinfoUtils.getCurrentUser();
            tv_company.setText(user.getCompanyName());
            tv_name.setText(user.getName());
            tv_profession.setText(user.getJob());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
            mActivity.registerReceiver(myReceiver, new IntentFilter(USER_INFO));
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            mActivity.unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }
}
