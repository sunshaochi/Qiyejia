package com.boyuanitsm.echinfo.http;

/**
 * 地址
 * Created by wangbin on 17/2/6.
 */
public class EchinoUrl {
    /*基础地址*/
    public static final String BASE_URL="http://172.16.6.253:8011/yiqicha/";
//    public static final String BASE_URL="http://172.16.6.146:8080/yiqicha/";

    /**用户 */
    /*登录*/
    public static final String LOGIN_URL=BASE_URL+"manager/unLogin/login.do";
    //获取短信验证码，注册
   public static final String GET_SMS_URL=BASE_URL+"manager/unLogin/sendSmsCaptcha.do";
    //注册用户
    public static final String TO_REGISTER_URL=BASE_URL+"manager/unLogin/register.do";
    //忘记密码
    public static final String FORGET_PASSWORD_URL=BASE_URL+"manager/unLogin/forgetPassword.do";
    //修改个人资料接口
    public static final String MODIFY_USER_URL=BASE_URL+"manager/login/modifyUserInfo.do";
    //修改密码
    public static final String MODIFY_PWD_URL=BASE_URL+"manager/login/modifyUserPassword.do";
    //修改用户头像
    public static final String MODIFY_HEAD_URL=BASE_URL+"manager/login/modifyUserIcon.do";
    //查找相关接口
    //职业类别
    String PROFESSION_URL=BASE_URL+"occupationMsg/unLogin/findOccupationList.do";


    /**企业向关 */
    /*感兴趣的企业*/
    public static final String INTEREST_COMPANY_URL=BASE_URL+"company/login/findEnterpriseInfoListByCompanyIdList.do";
}
