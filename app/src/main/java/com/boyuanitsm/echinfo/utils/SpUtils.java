package com.boyuanitsm.echinfo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wangbin on 17/2/7.
 */
public class SpUtils {

    private final static String ECHINO_SP="ztb_sp";
    private static final String COOKIE="cookie";


    public static SharedPreferences getSp(Context context) {
        return context.getSharedPreferences(ECHINO_SP, Context.MODE_PRIVATE);
    }

    /**
     * 保存cookie
     * @param context
     * @param cookie
     */
    public static void setCooike(Context context,String cookie){
        getSp(context).edit().putString(COOKIE, cookie).commit();
    }

    /**
     * 获取cookie
     * @param context
     * @return
     */
    public static String getCookie(Context context){
        return getSp(context).getString(COOKIE, "");
    }

}
