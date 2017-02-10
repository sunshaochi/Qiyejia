package com.boyuanitsm.echinfo.http.manager;

import android.text.TextUtils;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.EchinoUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找管理类
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class FindManager {
    private static FindManager findManager;

    public static FindManager getFindManager() {
        if (findManager == null) {
            findManager = new FindManager();
        }
        return findManager;
    }

    /**
     * 查专利
     *
     * @param name
     * @param patenType
     * @param releaseDate
     * @param page
     * @param rows
     * @param callback
     */
    public void findPatenInfoByName(String name, String patenType, String releaseDate, int page, int rows, ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(name)) {
            params.put("name", name);
        }
        if (!TextUtils.isEmpty(patenType)) {
            params.put("patenType", patenType);
        }
        if (!TextUtils.isEmpty(releaseDate)) {
            params.put("releaseDate", releaseDate);
        }
        params.put("page", page + "");
        params.put("rows", rows + "");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_PATENT_URL, params, callback);
    }

    /**
     * 获取专利类型?key=paten_type_key
     * @param callback
     */
    public void getPatentType(String type, ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("key", type);
        OkHttpManager.getInstance().doGet(EchinoUrl.PANTENT_TYPE_URL,params,callback);
    }

    /**
     * 获取热门搜索
     * @param type
     * @param callback
     */
    public void getHotSearchHistory(String type,ResultCallback callback){
        Map<String,String> params=new HashMap<>();
        params.put("type",type);
        OkHttpManager.getInstance().doGet(EchinoUrl.HOT_SEARCH_URL,params,callback);
    }

    /**
     * 查商标
     * @param name
     * @param type
     * @param page
     * @param rows
     * @param callback
     */

    public void getBrandInfo(String name,String type,int page,int rows,ResultCallback callback){
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(name)){
            params.put("name",name);
        }
        if (!TextUtils.isEmpty(type)){
            params.put("type",type);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_BRAND_URL,params,callback);
    }

    /**
     * 查法院判决
     * @param title
     * @param page
     * @param rows
     * @param callback
     */
    public void findJudgmentInfo(String title,int page,int rows,ResultCallback callback){
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(title)){
            params.put("title",title);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_JUDGMENT_URL,params,callback);
    }
}
