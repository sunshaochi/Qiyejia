package com.boyuanitsm.echinfo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by wangbin on 16/12/22.
 */
public abstract class BaseFrg<T extends BasePresenter> extends Fragment implements BaseView{

    // 将代理类通用行为抽出来
    protected T mPresenter;
    protected View mFragmentRootView;
    protected FragmentActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (null == mFragmentRootView) {
            mFragmentRootView = inflater.inflate(getLayout(), container, false);
            // 注入控件
            ButterKnife.bind(this,mFragmentRootView);
            initView(mFragmentRootView);
        }

        return mFragmentRootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (FragmentActivity) context;
    }

    public abstract int getLayout();

    protected abstract void initView(View fragmentRootView);

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }


    @Override
    public void toast(String msg) {

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
        Intent intent = new Intent(getContext(), pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        getActivity().startActivity(intent);
    }
}
