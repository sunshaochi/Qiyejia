package com.boyuanitsm.echinfo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.tools.utils.MyToastUtils;

import butterknife.ButterKnife;

/**
 * 基础类
 * Created by wangbin on 16/12/22.
 */
public abstract class BaseAct<T extends BasePresenter> extends FragmentActivity implements BaseView {
    private TextView tv_title;
    private TextView tvRight;
    private ImageView ivRight;
    private RelativeLayout rl_right;
    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 手机窗口设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(View.inflate(this, getLayout(), null));
        //注入控件
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    /**
     * 设置布局
     */
    public abstract int getLayout();

    /**
     * 填充数据
     */
    public abstract void init(Bundle savedInstanceState);


    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public void toast(String msg) {
        MyToastUtils.showShortToast(getApplicationContext(), msg);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    @Override
    public void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    /**
     * 设置顶部标题
     *
     * @param title
     */
    public void setTopTitle(String title) {
        tv_title = (TextView) findViewById(R.id.tv_title);
        if (title != null) {
            tv_title.setText(title);
        }
    }

    /**
     * 顶部右边按键
     *
     * @param rightText
     */
    public void setRightBtn(String rightText, View.OnClickListener listener) {
        tvRight = (TextView) findViewById(R.id.tvRight);
        rl_right = (RelativeLayout) findViewById(R.id.rl_right);
        if (!TextUtils.isEmpty(rightText)) {
            tvRight.setText(rightText);
            rl_right.setVisibility(View.VISIBLE);
            tvRight.setVisibility(View.VISIBLE);
        }
        if (listener != null) {
            rl_right.setOnClickListener(listener);
        }
    }

    /**
     * 顶部右边按键(带图片)
     *
     * @param res
     */
    public void setRightBtn(int res, View.OnClickListener listener) {
        ivRight = (ImageView) findViewById(R.id.ivRight);
        rl_right = (RelativeLayout) findViewById(R.id.rl_right);
        rl_right.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        if (listener != null) {
            rl_right.setOnClickListener(listener);
        }
    }

    public void goBack(View view) {
        finish();
    }
}
