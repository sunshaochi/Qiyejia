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
import com.boyuanitsm.echinfo.module.user.presenter.IForgetPwdPresenter;
import com.boyuanitsm.echinfo.module.user.presenter.IForgetPwdPresenterImpl;
import com.boyuanitsm.echinfo.module.user.view.IForgetPwdView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public class ForgetPwdAct extends BaseAct<IForgetPwdPresenter> implements IForgetPwdView {
    @BindView(R.id.register_phone)
    EditText forgetPhone;
    @BindView(R.id.register_code)
    EditText forgetCode;
    @BindView(R.id.tv_getCode)
    TextView tvGetCode;
    @BindView(R.id.register_pwd)
    EditText newPwd;
    @BindView(R.id.btn_register)
    Button resetPwd;
    String phone;
    Timer timer;
    MyTimerTask myTask;
    int i=60;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayout() {
        return R.layout.act_forgetpwd;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("忘记密码");
        mPresenter = new IForgetPwdPresenterImpl(this);
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
        tvGetCode.setEnabled(true);
        toast(errorMsg);
    }

    @Override
    public void toResetPwdSucess(String sucessMsg) {

    }

    @Override
    public void toResetPwdFaild(int status, String errorMsg) {

    }

    @OnClick({R.id.tv_getCode, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_getCode:
                phone = forgetPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    toast("请输入手机号");
                    return;
                }
                if (phone.length() != 11) {
                    toast("请输入11的手机号");
                    forgetPhone.requestFocus();
                    forgetPhone.setSelection(forgetPhone.length());
                    return;
                }
                if (!EchinfoUtils.checkCellPhone(phone)) {
                    toast("请输入正确的手机号码");
                    return;
                }
                tvGetCode.setEnabled(false);
                mPresenter.getSms(phone, "false");
                break;
            case R.id.btn_register:
                break;
        }
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
                tvGetCode.setEnabled(true);
                tvGetCode.setText("重新发送");
                timer.cancel();
                myTask.cancel();
            } else {
                tvGetCode.setText(msg.what + "秒");
            }
        }

    };
}
