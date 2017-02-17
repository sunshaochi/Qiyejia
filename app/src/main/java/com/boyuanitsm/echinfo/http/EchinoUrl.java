package com.boyuanitsm.echinfo.http;

/**
 * 地址
 * Created by wangbin on 17/2/6.
 */
public class EchinoUrl {
    /*基础地址*/
    public static final String BASE_URL="http://139.196.226.111:8006/yiqicha/";
//    public static final String BASE_URL="http://172.16.6.146:8080/yiqicha/";

    /**
     * 用户
     */
    /*登录*/
    public static final String LOGIN_URL = BASE_URL + "manager/unLogin/login.do";
    //获取短信验证码，注册
    public static final String GET_SMS_URL = BASE_URL + "manager/unLogin/sendSmsCaptcha.do";
    //注册用户
    public static final String TO_REGISTER_URL = BASE_URL + "manager/unLogin/register.do";
    //忘记密码
    public static final String FORGET_PASSWORD_URL = BASE_URL + "manager/unLogin/forgetPassword.do";
    //修改个人资料接口
    public static final String MODIFY_USER_URL = BASE_URL + "manager/login/modifyUserInfo.do";
    //修改密码
    public static final String MODIFY_PWD_URL = BASE_URL + "manager/login/modifyUserPassword.do";
    //修改用户头像
    public static final String MODIFY_HEAD_URL = BASE_URL + "manager/login/modifyUserIcon.do";
    //添加关注
    public static final String INSERTMYATT_URL = BASE_URL + "user/login/insertMyAttention.do";
    //取消关注
    public static final String DELETEMYATT_URL = BASE_URL + "user/login/deleteMyAttention.do";

    //关注列表
    public static final String FINDMYATT_URL = BASE_URL + "user/login/findMyAttentionListByAccountId.do";

    /**
     *     查找相关接口
     */
//    company/unlogin/findHotQuery.do//热门搜索接口：type
    //职业类别
    String PROFESSION_URL = BASE_URL + "occupationMsg/unLogin/findOccupationList.do";
    //查专利
    public static final String FIND_PATENT_URL = BASE_URL + "patenInfomation/unLogin/findPatenInfoByName.do";
    //专利类型
    public static final String PANTENT_TYPE_URL=BASE_URL+"manager/unLogin/findTypesByKey.do";
    //热门搜索
    public static final String HOT_SEARCH_URL=BASE_URL+"company/unlogin/findHotQuery.do";
    //查商标
    public static final String FIND_BRAND_URL=BASE_URL+"trademark/unLogin/findTrademarkInfoByName.do";
    //查法院判决
    public static final String FIND_JUDGMENT_URL=BASE_URL+"courtDecision/unLogin/findCourtDecisionInfo.do";
    //查执行
    public static final String FIND_IMPLEMENT_URL=BASE_URL+"breakExecutive/unLogin/findBreakExecutiveInfo.do";
    //查失信
    public static final String FIND_LOSE_CREDIT_URL=BASE_URL+"courtitem/unLogin/findCourtitemByName.do";
    //查企业根据名字
    public static final String FIND_STOCK_NAME_URL=BASE_URL+"company/unLogin/findEnterpriseInfoByName.do";
    //查经营范围
    public static final String FIND_JINGYING_URL=BASE_URL+"company/unLogin/findEnterpriseInfoByBusinessScope.do";
    //查品牌产品
    public static final String FIND_PINPAI_URL=BASE_URL+"company/unLogin/findEnterpriseInfoByProductName.do";
    //查股东高管
    public static final String FIND_GUDONG_URL=BASE_URL+"stockMsg/unLogin/findStockMsgInfo.do";
    /**
     * 企业向关
     */
    /*感兴趣的企业*/
    public static final String INTEREST_COMPANY_URL = BASE_URL + "company/login/findEnterpriseInfoListByCompanyIdList.do";
    /*企业详情*/
    public static final String COMANY_DETAIL_URL=BASE_URL+"view/login/findDetailedInfoById.do";
    /*对外投资*/
    public static final String INVES_DATA_URL=BASE_URL+"company/login/findAbroadInvestmentListByCompanyId.do";
    /*企业年报*/
    public static final String COMPANY_REPORT_URL=BASE_URL+"company/login/findAnnualPortsEnterpriseListByCompanyId.do";
    /*法院公告*/

    /*招聘信息*/
    public static final String FINDRECRUITING_URL=BASE_URL+"company/login/findRecruitingListByCompanyId.do";
    /*查询亲算信息*/
    public static final String FINDCLEARINFO_URL=BASE_URL+"company/login/findClearInfoListByCompanyId.do";
    /*查询融资信息*/
    public static final String FINDFINANCINGINFO_URL=BASE_URL+"company/login/findFinancingInfoListByCompanyId.do";
    /*查询股权出资信息*/
    public static final String FINDEQUITY_URL=BASE_URL+"company/login/findEquityPledgedListByCompanyId.do";

    /*企业资讯*/
    public static final String FINDENTERPRISE_URL=BASE_URL+"company/login/findEnterpriseNewsListByCompanyId.do";


    public static final String COURT_ANNO_URL=BASE_URL+"company/login/findCourtAnnouncementListByCompanyId.do";
    /*法院裁决*/
    public static final String COURT_ADJUDICATION=BASE_URL+"company/login/findCourtDecisionListByCompanyId.do";
    /*诉讼信息*/
    public static final String LITIGATION_URL=BASE_URL+"company/login/findLawsuitMsgListByCompanyId.do";
    /*诉讼信息详情*/
    public static final String LITIGATION_DETAIL_URL=BASE_URL+"view/login/findLawsuitMsgById.do";
    /*行政处罚*/
    public static final String ADMINISTRATIVE_URL=BASE_URL+"company/login/findAdministrativePenaltyListByCompanyId.do";
    /*经营异常*/
    public static final String MANAGEMENT_EXCEPTION_URL=BASE_URL+"company/login/findManageExceptionListBycompanyId.do";
    /*抽查检查*/
    public static final String FIND_CHECK_URL=BASE_URL+"company/login/findSpotCheckListByCompanyI.do";
    /*通过公司ID查专利*/
    public static final String PATENT_BY_ID_URL=BASE_URL+"company/login/findPatenInfomationByCompanyId.do";
    /*查询原创著作权*/
    public static final String COPYRIGHTS_BYID_URL=BASE_URL+"company/login/findCopyrightsByCompanyId.do";
    /*查询软件著作权*/
    public static final String SOFTWORE_RIGHT_URL=BASE_URL+"company/ogin/findSoftwareCopyrightByCompanyId.do";

    /*意见反馈*/
    public static final String INSERTIDEATICKING_URL=BASE_URL+"company/login/insertIdeaTicking.do";
}
