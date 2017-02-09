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
        OkHttpManager.getInstance().doPost(EchinoUrl.INTEREST_COMPANY_URL,params,resultCallback);
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

}
