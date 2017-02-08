package com.boyuanitsm.echinfo.http.manager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.boyuanitsm.echinfo.MyApplication;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.HttpHeaderHelper;
import com.boyuanitsm.echinfo.http.param.Param;
import com.boyuanitsm.echinfo.utils.SpUtils;
import com.boyuanitsm.tools.utils.GsonUtils;
import com.boyuanitsm.tools.utils.MyLogUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangbin on 17/2/6.
 */
public class OkHttpManager {

    private static OkHttpClient mOkHttpClient;
    private Headers headers;
    private static OkHttpManager mInstance;
    private Gson mGson;
    private Handler mDelivery;

    private OkHttpManager() {
        mGson = new Gson();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        mOkHttpClient = builder.build();
        //cookie enabled
        mDelivery = new Handler(Looper.getMainLooper());
    }

    public static OkHttpManager getInstance() {
        if (mInstance == null) {
            if (mInstance == null) {
                mInstance = new OkHttpManager();
            }
        }
        return mInstance;
    }

    private Param[] map2Params(Map<String, String> params) {
        if (params == null) return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

    /**
     * post请求  键值对
     *
     * @param url
     * @param paramMap
     * @return
     */
    public void doPost(String url, Map<String, String> paramMap, final ResultCallback callback) {
        headers = HttpHeaderHelper.getHeaders();
        MyLogUtils.info("请求地址:" + url);
        MyLogUtils.info("请求参数:" + GsonUtils.bean2Json(paramMap));
        FormBody.Builder parmBuilder = new FormBody.Builder();
        Param[] params = map2Params(paramMap);
        if (params != null && params.length > 0) {
            for (Param param : params) {
                parmBuilder.add(param.key, param.value);
            }
        }

        Request.Builder builder = new Request.Builder();
        builder.url(url).post(parmBuilder.build());
        if (headers != null) {
            MyLogUtils.info("headers内容是===="+headers);
            builder.headers(headers);
        }

        Request request = builder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedStringCallback(-1, "请求失败，请检查网络！", callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获取cookie
                String header = response.header("Set-Cookie");
                MyLogUtils.info("获取到cookie:" + header);

                if (!TextUtils.isEmpty(header))
                    SpUtils.setCooike(MyApplication.getInstances(), header);

                final String result = response.body().string();
                MyLogUtils.info("获取result：" + result);

                if(response.isSuccessful()) {
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(result, callback);
                    } else {
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            int status = jsonObject.getInt("status");
                            if (status == 200) {//成功
                                Object o = mGson.fromJson(result, callback.mType);
                                sendSuccessResultCallback(o, callback);
                            } else if (status == 601) {
                                sendFailedStringCallback(status, result, callback);
                            } else {//失败
                                sendFailedStringCallback(status, jsonObject.getString("message"), callback);
                            }
                        } catch (Exception e) {
//                            e.printStackTrace();
                            sendFailedStringCallback(-1, "解析异常", callback);
                        }
                    }
                }else {
                    sendFailedStringCallback(-1, "请求失败，请检查网络！", callback);
                }

            }
        });
    }


    /**
     * get请求  键值对
     * @param url
     * @param paramMap
     * @return
     */
    public void doGet(String url, Map<String, String> paramMap, final ResultCallback callback) {
        headers = HttpHeaderHelper.getHeaders();
        StringBuilder tempParams = new StringBuilder(url);

        MyLogUtils.info("请求地址:" + url);
        MyLogUtils.info("请求参数:" + GsonUtils.bean2Json(paramMap));

        if(paramMap!=null&&paramMap.size()>0){
            int pos = 0;
            for (String key : paramMap.keySet()) {
                if (pos > 0) {
                    tempParams.append("&");
                }
                try {
                    tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramMap.get(key), "utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pos++;
            }
            url=url+"?"+tempParams.toString();
        }

        Request.Builder builder = new Request.Builder();
        builder.url(url).build();
        if (headers != null) {
            MyLogUtils.info("headers内容是===="+headers);
            builder.headers(headers);
        }

        Request request = builder.build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedStringCallback(-1, "请求失败，请检查网络！", callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获取cookie
                String header = response.header("Set-Cookie");
                MyLogUtils.info("获取到cookie:" + header);

                if (!TextUtils.isEmpty(header))
                    SpUtils.setCooike(MyApplication.getInstances(), header);

                final String result = response.body().string();
                MyLogUtils.info("获取result：" + result);

                if(response.isSuccessful()) {
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(result, callback);
                    } else {
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            int status = jsonObject.getInt("status");
                            if (status == 200) {//成功
                                Object o = mGson.fromJson(result, callback.mType);
                                sendSuccessResultCallback(o, callback);
                            } else if (status == 601) {
                                sendFailedStringCallback(status, result, callback);
                            } else {//失败
                                sendFailedStringCallback(status, jsonObject.getString("message"), callback);
                            }
                        } catch (Exception e) {
//                            e.printStackTrace();
                            sendFailedStringCallback(-1, "解析异常", callback);
                        }
                    }
                }else {
                    sendFailedStringCallback(-1, "请求失败，请检查网络！", callback);
                }

            }
        });

    }

    private void sendFailedStringCallback(final int status, final String e, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null)
                    callback.onError(status, e);
            }
        });
    }

    private void sendSuccessResultCallback(final Object object, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onResponse(object);
                }
            }
        });
    }



}
