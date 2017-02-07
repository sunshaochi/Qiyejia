package com.boyuanitsm.echinfo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wangbin on 17/2/6.
 */
@Entity
public class UserBean  {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String mobilePhoneKey;
    private String phone;
    private String bindMobileCount;
    private String email;
    private String qq;
    private String wechat;
    private String icon;
    private String token;
    private String referralCode;
    private String myReferralCode;
    private String companyName;
    private String companyAddr;
    private String companyPhone;
    private String job;
    private String userType;
    private String isValid;
    private String createPersonId;
    private String createTime;
    private String modifyPersonId;
    private String modifyTime;
    private String remark;
    private String empno;
    private String dictId;
    private String accredit;
    public String getAccredit() {
        return this.accredit;
    }
    public void setAccredit(String accredit) {
        this.accredit = accredit;
    }
    public String getDictId() {
        return this.dictId;
    }
    public void setDictId(String dictId) {
        this.dictId = dictId;
    }
    public String getEmpno() {
        return this.empno;
    }
    public void setEmpno(String empno) {
        this.empno = empno;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getModifyTime() {
        return this.modifyTime;
    }
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getModifyPersonId() {
        return this.modifyPersonId;
    }
    public void setModifyPersonId(String modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }
    public String getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCreatePersonId() {
        return this.createPersonId;
    }
    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }
    public String getIsValid() {
        return this.isValid;
    }
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
    public String getUserType() {
        return this.userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getCompanyPhone() {
        return this.companyPhone;
    }
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
    public String getCompanyAddr() {
        return this.companyAddr;
    }
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getMyReferralCode() {
        return this.myReferralCode;
    }
    public void setMyReferralCode(String myReferralCode) {
        this.myReferralCode = myReferralCode;
    }
    public String getReferralCode() {
        return this.referralCode;
    }
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getWechat() {
        return this.wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    public String getQq() {
        return this.qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBindMobileCount() {
        return this.bindMobileCount;
    }
    public void setBindMobileCount(String bindMobileCount) {
        this.bindMobileCount = bindMobileCount;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMobilePhoneKey() {
        return this.mobilePhoneKey;
    }
    public void setMobilePhoneKey(String mobilePhoneKey) {
        this.mobilePhoneKey = mobilePhoneKey;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Generated(hash = 1974141979)
    public UserBean(String id, String username, String password, String name,
            String mobilePhoneKey, String phone, String bindMobileCount,
            String email, String qq, String wechat, String icon, String token,
            String referralCode, String myReferralCode, String companyName,
            String companyAddr, String companyPhone, String job, String userType,
            String isValid, String createPersonId, String createTime,
            String modifyPersonId, String modifyTime, String remark, String empno,
            String dictId, String accredit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobilePhoneKey = mobilePhoneKey;
        this.phone = phone;
        this.bindMobileCount = bindMobileCount;
        this.email = email;
        this.qq = qq;
        this.wechat = wechat;
        this.icon = icon;
        this.token = token;
        this.referralCode = referralCode;
        this.myReferralCode = myReferralCode;
        this.companyName = companyName;
        this.companyAddr = companyAddr;
        this.companyPhone = companyPhone;
        this.job = job;
        this.userType = userType;
        this.isValid = isValid;
        this.createPersonId = createPersonId;
        this.createTime = createTime;
        this.modifyPersonId = modifyPersonId;
        this.modifyTime = modifyTime;
        this.remark = remark;
        this.empno = empno;
        this.dictId = dictId;
        this.accredit = accredit;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }


}
