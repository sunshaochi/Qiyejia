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

    /**
     * 查询执行
     * @param name
     * @param page
     * @param rows
     * @param callback
     */
    public void findImplementInfo(String name, int page, int rows, ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(name)){
            params.put("breakExecutive",name);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_IMPLEMENT_URL,params,callback);
    }

    /**
     * 查失信
     * @param name
     * @param page
     * @param rows
     * @param callback
     */

    public void findLoseCreditInfo(String name, int page, int rows, ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(name)){
            params.put("iname",name);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_LOSE_CREDIT_URL,params,callback);
    }

    /**
     * 根据公司名称查找企业
     * companyName - 企业名称
     address - 区域
     industry - 行业
     capital - 注册资金（闭区间）开始不限capital=*,x；结束不限capital=x,*；0-1万人民币 capital=0,10000；
     establishDate - 成立时间（闭区间）时间格式 2016-12-13，规则同注册资金
     * @param companyName
     * @param address
     * @param industry
     * @param capital
     * @param establishDate
     * @param page
     * @param rows
     * @param callback
     */
    public void findStockByName(String companyName,String address,String industry,String capital,String establishDate,boolean isRangeQuery ,String screeningRange ,int page,int rows,ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(companyName)){
            params.put("companyName",companyName);
        }
        if (!TextUtils.isEmpty(address)){
            params.put("address",address);
        }
        if (!TextUtils.isEmpty(industry)){
            params.put("industry",industry);
        }
        if (!TextUtils.isEmpty(capital)){
            params.put("capital",capital);
        }
        if (!TextUtils.isEmpty(establishDate)){
            params.put("establishDate",establishDate);
        }
        params.put("isRangeQuery",isRangeQuery+"");
        if (!TextUtils.isEmpty(screeningRange)){
            params.put("screeningRange",screeningRange);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_STOCK_NAME_URL,params,callback);
    }
    /**
     * 根据经营范围查找企业
     * companyName - 企业名称
     address - 区域
     industry - 行业
     capital - 注册资金（闭区间）开始不限capital=*,x；结束不限capital=x,*；0-1万人民币 capital=0,10000；
     establishDate - 成立时间（闭区间）时间格式 2016-12-13，规则同注册资金
     * @param businessScope
     * @param address
     * @param industry
     * @param capital
     * @param establishDate
     * @param page
     * @param rows
     * @param callback
     */
    public void findEnterpriseInfoByBusinessScope(String businessScope ,String address,String industry,String capital,String establishDate,int page,int rows,ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(businessScope )){
            params.put("businessScope ",businessScope );
        }
        if (!TextUtils.isEmpty(address)){
            params.put("address",address);
        }
        if (!TextUtils.isEmpty(industry)){
            params.put("industry",industry);
        }
        if (!TextUtils.isEmpty(capital)){
            params.put("capital",capital);
        }
        if (!TextUtils.isEmpty(establishDate)){
            params.put("establishDate",establishDate);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_JINGYING_URL,params,callback);
    }
    /**
     * 根据品牌查找企业
     * companyName - 企业名称
     address - 区域
     industry - 行业
     capital - 注册资金（闭区间）开始不限capital=*,x；结束不限capital=x,*；0-1万人民币 capital=0,10000；
     establishDate - 成立时间（闭区间）时间格式 2016-12-13，规则同注册资金
     * @param webAddress
     * @param address
     * @param industry
     * @param capital
     * @param establishDate
     * @param page
     * @param rows
     * @param callback
     */
    public void findEnterpriseInfoByProductName(String webAddress  ,String address,String industry,String capital,String establishDate,int page,int rows,ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(webAddress  )){
            params.put("webAddress",webAddress  );
        }
        if (!TextUtils.isEmpty(address)){
            params.put("address",address);
        }
        if (!TextUtils.isEmpty(industry)){
            params.put("industry",industry);
        }
        if (!TextUtils.isEmpty(capital)){
            params.put("capital",capital);
        }
        if (!TextUtils.isEmpty(establishDate)){
            params.put("establishDate",establishDate);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_PINPAI_URL,params,callback);
    }
    /**
     * 根据股东/高管查找企业
     * companyName - 企业名称
     address - 区域
     industry - 行业
     capital - 注册资金（闭区间）开始不限capital=*,x；结束不限capital=x,*；0-1万人民币 capital=0,10000；
     establishDate - 成立时间（闭区间）时间格式 2016-12-13，规则同注册资金
     * @param stockMsgName
     * @param address
     * @param industry
     * @param capital
     * @param establishDate
     * @param page
     * @param rows
     * @param callback
     */
    public void findStockMsgInfo(String stockMsgName   ,String address,String industry,String capital,String establishDate,int page,int rows,ResultCallback callback) {
        Map<String,String> params=new HashMap<>();
        if (!TextUtils.isEmpty(stockMsgName  )){
            params.put("stockMsgName",stockMsgName  );
        }
        if (!TextUtils.isEmpty(address)){
            params.put("address",address);
        }
        if (!TextUtils.isEmpty(industry)){
            params.put("industry",industry);
        }
        if (!TextUtils.isEmpty(capital)){
            params.put("capital",capital);
        }
        if (!TextUtils.isEmpty(establishDate)){
            params.put("establishDate",establishDate);
        }
        params.put("page",page+"");
        params.put("rows",rows+"");
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_GUDONG_URL,params,callback);
    }
}
