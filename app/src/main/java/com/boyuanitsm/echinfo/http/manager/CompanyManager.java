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
     * 查询诉讼信息详情
     * @param id
     * @param resultCallback
     */
    public void getLitigationDetail(String id,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("id",id);
        OkHttpManager.getInstance().doGet(EchinoUrl.LITIGATION_DETAIL_URL,params,resultCallback);
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

    /**
     * 抽查检查
     * @param companyId
     * @param resultCallback
     */
    public void getFindCheck(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_CHECK_URL,params,resultCallback);
    }

    /**
     * 通过公司id查专利
     * @param companyId
     * @param resultCallback
     */
    public void getPatentById(String companyId,ResultCallback resultCallback){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.PATENT_BY_ID_URL,params,resultCallback);
    }

    /**
     * 查询原创著作权
     * @param companyId
     * @param resultCallback
     */
    public void getCopyrightsById(String companyId,ResultCallback resultCallback ){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COPYRIGHTS_BYID_URL,params,resultCallback);
    }

    /**
     * 查询软件著作权
     * @param companyId
     * @param resultCallback
     */
    public void getSoftwarerightsById(String companyId,ResultCallback resultCallback ){
        Map<String,String> params=new HashMap<>();
        params.put("companyId",companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.SOFTWORE_RIGHT_URL,params,resultCallback);
    }

}
