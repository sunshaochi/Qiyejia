package com.boyuanitsm.echinfo.http;

import android.text.TextUtils;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.utils.SpUtils;

import java.util.HashMap;

import okhttp3.Headers;

/**
 * Created by wangbin on 16/8/23.
 */
public class HttpHeaderHelper {

    /**
     * 获取请求头
     * @param
     * @return
     */
    public static Headers getHeaders() {
        HashMap<String, String> map = new HashMap<>();
        if(!TextUtils.isEmpty(SpUtils.getCookie(MyApplication.getInstances()))){
            map.put("Cookie",SpUtils.getCookie(MyApplication.getInstances()));
        }
        if(map.size()==0){
            return null;
        }else {
            return Headers.of(map);
        }
    }
}
