package com.boyuanitsm.echinfo.http.manager;

import android.text.TextUtils;

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

    public static CompanyManager getCompanyManager() {
        if (companyManager == null) {
            companyManager = new CompanyManager();
        }
        return companyManager;
    }

    /**
     * 感兴趣的企业
     *
     * @param resultCallback
     */
    public void toGetInterestCompany(ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        OkHttpManager.getInstance().doGet(EchinoUrl.INTEREST_COMPANY_URL, params, resultCallback);
    }

    /**
     * 查询企业详情
     *
     * @param companyId
     * @param resultCallback
     */
    public void toGetCompanyDetail(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COMANY_DETAIL_URL, params, resultCallback);
    }

    /**
     * 查询对外投资
     *
     * @param companyId
     * @param resultCallback
     */
    public void toGetInves(String companyId,String year,ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        if(!TextUtils.isEmpty(year))
            params.put("year",year);
        OkHttpManager.getInstance().doGet(EchinoUrl.INVES_DATA_URL, params, resultCallback);
    }

    /**
     * 查询企业年报
     *
     * @param companyId
     * @param resultCallback
     */
    public void toGetComanyReport(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COMPANY_REPORT_URL, params, resultCallback);
    }

    /**
     * 法院公告
     *
     * @param companyId
     * @param resultCallback
     */
    public void getCourtAnno(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COURT_ANNO_URL, params, resultCallback);
    }

    /**
     * 招聘信息
     *
     * @param companyId
     * @param resultCallback
     */
    public void getRecruitment(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDRECRUITING_URL, params, resultCallback);
    }

    /**
     * 查询清算信息
     *
     * @param companyId
     * @param resultCallback
     */
    public void geFindclearinfo(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDCLEARINFO_URL, params, resultCallback);
    }

    /**
     * 企业资讯
     *
     * @param companyId
     * @param resultCallback
     */
    public void getEnterpriseNews(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDENTERPRISE_URL, params, resultCallback);
    }


    /**
     * 法院裁决
     *
     * @param companyId
     * @param resultCallback
     */
    public void getCourtAdjudication(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COURT_ADJUDICATION, params, resultCallback);
    }

    /**
     * 诉讼信息
     *
     * @param companyId
     * @param resultCallback
     */
    public void getLitigation(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.LITIGATION_URL, params, resultCallback);
    }

    /**
     * 查询诉讼信息详情
     *
     * @param id
     * @param resultCallback
     */
    public void getLitigationDetail(String id, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        OkHttpManager.getInstance().doGet(EchinoUrl.LITIGATION_DETAIL_URL, params, resultCallback);
    }

    /**
     * 获取行政处罚
     *
     * @param companyId
     * @param resultCallback
     */
    public void getAdministrativeDatas(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.ADMINISTRATIVE_URL, params, resultCallback);
    }

    /**
     * 查询经营异常信息
     *
     * @param companyId
     * @param resultCallback
     */
    public void getManagerException(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.MANAGEMENT_EXCEPTION_URL, params, resultCallback);
    }


    /**
     * 查询融资记录
     *
     * @param companyId
     * @param resultCallback
     */
    public void getFinancInfo(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDFINANCINGINFO_URL, params, resultCallback);
    }

    /**
     * 获取股权出资
     *
     * @param companyId
     * @param resultCallback
     */
    public void getEquitylist(String companyId, String year, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        if (!TextUtils.isEmpty(year))
            params.put("year", year);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDEQUITY_URL, params, resultCallback);
    }


    /**
     * 抽查检查
     *
     * @param companyId
     * @param resultCallback
     */
    public void getFindCheck(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_CHECK_URL, params, resultCallback);
    }

    /**
     * 通过公司id查专利
     *
     * @param companyId
     * @param resultCallback
     */
    public void getPatentById(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.PATENT_BY_ID_URL, params, resultCallback);
    }

    /**
     * 查询原创著作权
     *
     * @param companyId
     * @param resultCallback
     */
    public void getCopyrightsById(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.COPYRIGHTS_BYID_URL, params, resultCallback);
    }

    /**
     * 查询软件著作权
     *
     * @param companyId
     * @param resultCallback
     */
    public void getSoftwarerightsById(String companyId, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.SOFTWORE_RIGHT_URL, params, resultCallback);
    }

    /**
     * 获取纠错列表
     *
     * @param dictType
     * @param resultCallback
     */
    public void getErrorCorrectionList(String dictType, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("dictType", dictType);
        OkHttpManager.getInstance().doPost(EchinoUrl.ERROR_LIST_URL, params, resultCallback);
    }

    /**
     * 提交纠错信息
     *
     * @param companyId
     * @param errorParts
     * @param errorContent
     * @param mobileEmailQqNo
     * @param status
     * @param resultCallback
     */
    public void submitErrorMsg(String companyId, String errorParts, String errorContent, String mobileEmailQqNo, int status, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        params.put("errorParts", errorParts);
        params.put("errorContent", errorContent);
        params.put("mobileEmailQqNo", mobileEmailQqNo);
        params.put("status", status + "");
        OkHttpManager.getInstance().doPost(EchinoUrl.ERROR_SUBMIT_URL, params, resultCallback);
    }

    /**
     * 意见反馈
     *
     * @param content
     * @param mobileEmailQqNo
     * @param resultCallback
     */
    public void CommitIdeaTicking(String content, String mobileEmailQqNo, ResultCallback resultCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("content", content);
        params.put("mobileEmailQqNo", mobileEmailQqNo);
        OkHttpManager.getInstance().doPost(EchinoUrl.INSERTIDEATICKING_URL, params, resultCallback);

    }

    /**
     * 获取企业证书列表
     *
     * @param companyId
     * @param callback
     */

    public void getQiYeList(String companyId, ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.GET_QIYE_LIST, params, callback);
    }

    /**
     * 查询企业变更记录
     *
     * @param companyId
     * @param year
     * @param callback
     */
    public void getCompanyEditRecord(String companyId, String year, ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        if (!TextUtils.isEmpty(year)) {
            params.put("year", year);
        }
        OkHttpManager.getInstance().doGet(EchinoUrl.EDIT_RECORD_URL, params, callback);
    }

    /** 注册网站
     * @param companyId
     * @param callback
     */
    public void Findweb(String companyId,String year,ResultCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        if(!TextUtils.isEmpty(year))
            params.put("year", year);
        OkHttpManager.getInstance().doGet(EchinoUrl.FINDWEB_URL, params, callback);
    }

    /**
     * 查询股东
     * @param companyId
     * @param callback
     */
    public void toFindStockMsg(String companyId,ResultCallback callback){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_STOCK_URL, params, callback);
    }

    /**
     * 查询企业无统计
     * @param id
     * @param callback
     */
    public void toFindCompanyNo(String id,ResultCallback callback){
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_COMPANY_NO_URL, params, callback);
    }

    /**
     * 主要成员
     * @param companyId
     * @param resultCallback
     */
    public void toFindMainMember(String companyId,ResultCallback resultCallback){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_MAIN_MEMBER_URL, params, resultCallback);
    }

    /**
     * 查询分支机构
     * @param companyId
     * @param resultCallback
     */
    public void toFindSonEnterprise(String companyId,ResultCallback resultCallback){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_SONENTERPRISE_URL, params, resultCallback);
    }

    /**
     * 抽查检查
     * @param companyId
     * @param resultCallback
     */
    public void toFindSpotCheck(String companyId,ResultCallback resultCallback){
        Map<String, String> params = new HashMap<>();
        params.put("companyId", companyId);
        OkHttpManager.getInstance().doGet(EchinoUrl.FIND_SPOTCHECKLIST_URL, params, resultCallback);
    }
}
