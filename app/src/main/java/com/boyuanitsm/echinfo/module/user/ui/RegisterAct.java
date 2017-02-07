package com.boyuanitsm.echinfo.module.user.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.module.user.presenter.IRegisterPresenter;
import com.boyuanitsm.echinfo.module.user.presenter.RegisterPresenterImpl;
import com.boyuanitsm.echinfo.module.user.view.IRegisterView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.AppManager;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by Yang on 2016/12/30 0030.
 */
public class RegisterAct extends BaseAct<IRegisterPresenter> implements IRegisterView {
    @BindView(R.id.register_phone)
    EditText register_phone;
    @BindView(R.id.register_code)
    EditText register_code;
    @BindView(R.id.register_pwd)
    EditText register_pwd;
    @BindView(R.id.tv_getCode)
    TextView tv_getCode;
    @BindView(R.id.btn_register)
    Button btn_register;
    private String phone;
    private String rg_code;
    private int i = 60;
    private Timer timer;
    private MyTimerTask myTask;
    private UserBean user;

    @Override
    public int getLayout() {
        return R.layout.act_register;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("注册");
        mPresenter = new RegisterPresenterImpl(this);
        user = new UserBean();
    }

    @OnClick({R.id.tv_getCode, R.id.btn_register, R.id.ll_xy})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_getCode://获取验证码
                phone = register_phone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    toast("请输入手机号");
                    return;
                }
                if (phone.length() != 11) {
                    toast("请输入11的手机号");
                    register_phone.requestFocus();
                    register_phone.setSelection(register_phone.length());
                    return;
                }
                if (!EchinfoUtils.checkCellPhone(phone)) {
                    toast("请输入正确的手机号码");
                    return;
                }
                tv_getCode.setEnabled(false);
                mPresenter.getSms(phone, "true");
                break;
            case R.id.btn_register://完成注册
                btn_register.setEnabled(false);
                phone = register_phone.getText().toString().trim();
                rg_code = register_code.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    toast("请输入手机号");
                    return;
                }
                if (phone.length() != 11) {
                    toast("请输入11的手机号");
                    register_phone.requestFocus();
                    register_phone.setSelection(register_phone.length());
                    return;
                }
                if (!EchinfoUtils.checkCellPhone(phone)) {
                    toast("请输入正确的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(rg_code)) {
                    toast("请输入验证码");
                    return;
                }
                user.setUsername(phone);
                AppManager.getAppManager().addActivity(RegisterAct.this);
                mPresenter.toRegister(user, rg_code);
                break;
            case R.id.ll_xy://服务协议
                break;
        }
    }

    @Override
    public void getSmsSucess(String sucessMsg) {
        i = 60;
        timer = new Timer();
        myTask = new MyTimerTask();
        timer.schedule(myTask, 0, 1000);
        toast("验证码发送成功");

    }

    @Override
    public void getSmsFaild(int status, String errorMsg) {
        tv_getCode.setEnabled(true);
        toast(errorMsg);
    }

    @Override
    public void toRegisterSucess(UserBean userBean,String sucessMsg) {
        btn_register.setEnabled(true);
        openActivity(RegisterSuccessAct.class);
        toast(sucessMsg);
    }

    @Override
    public void toRegisterFaild(int status, String errorMsg) {
        btn_register.setEnabled(true);
        toast(errorMsg);
    }

    /**
     * 倒计时
     *
     * @author wangbin
     */
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            handler.sendEmptyMessage(i--);
        }

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0 || msg.what < 0) {
                tv_getCode.setEnabled(true);
                tv_getCode.setText("重新发送");
                timer.cancel();
                myTask.cancel();
            } else {
                tv_getCode.setText(msg.what + "秒");
            }
        }

    };
}
