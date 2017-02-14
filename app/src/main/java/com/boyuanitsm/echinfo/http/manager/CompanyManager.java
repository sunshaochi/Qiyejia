package com.boyuanitsm.echinfo.http.manager;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.EchinoUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司管理类
 * Created by wangbin on 17/2/6.
 */
public class CompanyManager {

    private static CompanyManager companyManager;

    public static CompanyManager getCompanyManager(){
        if(companyManager==null){
            companyManager=new CompanyManager();
        }
        return companyManager;
    }

    /**
     * 感兴趣的企业
     * @param resultCallback
     */
    public void toGetInterestCompany(ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        OkHttpManager.getInstance().doGet(EchinoUrl.INTEREST_COMPANY_URL,params,resultCallback);
    }

    /**
     * 查询企业详情
     * @param companyId
     * @param resultCallback
     */
    public void toGetCompanyDetail(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COMANY_DETAIL_URL,params,resultCallback);
    }

    /**
     * 查询对外投资
     * @param companyId
     * @param resultCallback
     */
    public void toGetInves(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.INVES_DATA_URL,params,resultCallback);
    }

    /**
     * 查询企业年报
     * @param companyId
     * @param resultCallback
     */
    public void toGetComanyReport(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COMPANY_REPORT_URL,params,resultCallback);
    }

    /**
     * 法院公告
     * @param companyId
     * @param resultCallback
     */
    public void getCourtAnno(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COURT_ANNO_URL,params,resultCallback);
    }

    /**
     * 招聘信息
     * @param companyId
     * @param resultCallback
     */
    public void getRecruitment(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDRECRUITING_URL,params,resultCallback);
    }

    /**
     * 查询清算信息
     * @param companyId
     * @param resultCallback
     */
    public void geFindclearinfo(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDCLEARINFO_URL,params,resultCallback);
    }

    /**
     * 企业资讯
     * @param companyId
     * @param resultCallback
     */
    public void getEnterpriseNews(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDENTERPRISE_URL,params,resultCallback);
    }





    /**
     * 法院裁决
     * @param companyId
     * @param resultCallback
     */
    public void getCourtAdjudication(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COURT_ADJUDICATION,params,resultCallback);
    }

    /**
     *  诉讼信息
     * @param companyId
     * @param resultCallback
     */
    public void getLitigation(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.LITIGATION_URL,params,resultCallback);
    }

    /**
     * 获取行政处罚
     * @param companyId
     * @param resultCallback
     */
    public void getAdministrativeDatas(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.ADMINISTRATIVE_URL,params,resultCallback);
    }

    /**
     * 查询经营异常信息
     * @param companyId
     * @param resultCallback
     */
    public void getManagerException(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.MANAGEMENT_EXCEPTION_URL,params,resultCallback);
    }

}
