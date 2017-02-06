package com.boyuanitsm.echinfo.http;

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
        if(map.size()==0){
            return null;
        }else {
            return Headers.of(map);
        }
    }
}
