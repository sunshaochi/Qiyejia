package com.boyuanitsm.echinfo.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.tools.view.xrecyclerview.ProgressStyle;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 工具类
 * Created by wangbin on 16/12/23.
 */
public class EchinfoUtils {


    /**
     * 初始化下拉刷新
     *
     * @param context
     * @return
     */
    public static XRecyclerView getLinearRecyclerView(XRecyclerView rcv, Context context, boolean isCanLoadMore) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        rcv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        rcv.setArrowImageView(com.boyuanitsm.tools.R.drawable.iconfont_downgrey);
        rcv.setLoadingMoreEnabled(isCanLoadMore);
        rcv.setLayoutManager(linearLayoutManager);
        return rcv;
    }

    /**
     * 动态设置宽高
     *
     * @param v
     * @param w
     * @param h
     */
    public static void setViewWh(View v, int w, int h) {
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.width = w;
        params.height = h;
        v.setLayoutParams(params);
    }

    /**
     * 获取测试List
     *
     * @param length
     * @return
     */
    public static List<String> getTestDatas(int length) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            datas.add(i + "");
        }
        return datas;
    }

    /**
     * 用户是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        List<UserBean> list = MyApplication.getInstances().getDaoSession().getUserBeanDao().loadAll();
        if (list == null || list.size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static UserBean getCurrentUser() {
        List<UserBean> list = MyApplication.getInstances().getDaoSession().getUserBeanDao().loadAll();
        return list.get(0);
    }

}
