package com.boyuanitsm.echinfo.http;

/**
 * 地址
 * Created by wangbin on 17/2/6.
 */
public class EchinoUrl {
    /*基础地址*/
//    public static final String BASE_URL="http://172.16.6.253:8011/yiqicha/";
    public static final String BASE_URL="http://172.16.6.146:8080/yiqicha/";

    /**用户 */
    /*登录*/
    public static final String LOGIN_URL=BASE_URL+"manager/unLogin/login.do";
    //获取短信验证码，注册
   public static final String GET_SMS_URL=BASE_URL+"manager/unLogin/sendSmsCaptcha.do";
    //注册用户
    public static final String TO_REGISTER_URL=BASE_URL+"manager/unLogin/register.do";
    //查找相关接口
    //职业类别
    String PROFESSION_URL=BASE_URL+"occupationMsg/unLogin/findOccupationList.do";
}
