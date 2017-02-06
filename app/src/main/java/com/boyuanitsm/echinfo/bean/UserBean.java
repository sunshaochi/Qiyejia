package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangbin on 17/2/6.
 */
public class UserBean implements Parcelable {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhoneKey() {
        return mobilePhoneKey;
    }

    public void setMobilePhoneKey(String mobilePhoneKey) {
        this.mobilePhoneKey = mobilePhoneKey;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBindMobileCount() {
        return bindMobileCount;
    }

    public void setBindMobileCount(String bindMobileCount) {
        this.bindMobileCount = bindMobileCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getMyReferralCode() {
        return myReferralCode;
    }

    public void setMyReferralCode(String myReferralCode) {
        this.myReferralCode = myReferralCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(String modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getAccredit() {
        return accredit;
    }

    public void setAccredit(String accredit) {
        this.accredit = accredit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.name);
        dest.writeString(this.mobilePhoneKey);
        dest.writeString(this.phone);
        dest.writeString(this.bindMobileCount);
        dest.writeString(this.email);
        dest.writeString(this.qq);
        dest.writeString(this.wechat);
        dest.writeString(this.icon);
        dest.writeString(this.token);
        dest.writeString(this.referralCode);
        dest.writeString(this.myReferralCode);
        dest.writeString(this.companyName);
        dest.writeString(this.companyAddr);
        dest.writeString(this.companyPhone);
        dest.writeString(this.job);
        dest.writeString(this.userType);
        dest.writeString(this.isValid);
        dest.writeString(this.createPersonId);
        dest.writeString(this.createTime);
        dest.writeString(this.modifyPersonId);
        dest.writeString(this.modifyTime);
        dest.writeString(this.remark);
        dest.writeString(this.empno);
        dest.writeString(this.dictId);
        dest.writeString(this.accredit);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.password = in.readString();
        this.name = in.readString();
        this.mobilePhoneKey = in.readString();
        this.phone = in.readString();
        this.bindMobileCount = in.readString();
        this.email = in.readString();
        this.qq = in.readString();
        this.wechat = in.readString();
        this.icon = in.readString();
        this.token = in.readString();
        this.referralCode = in.readString();
        this.myReferralCode = in.readString();
        this.companyName = in.readString();
        this.companyAddr = in.readString();
        this.companyPhone = in.readString();
        this.job = in.readString();
        this.userType = in.readString();
        this.isValid = in.readString();
        this.createPersonId = in.readString();
        this.createTime = in.readString();
        this.modifyPersonId = in.readString();
        this.modifyTime = in.readString();
        this.remark = in.readString();
        this.empno = in.readString();
        this.dictId = in.readString();
        this.accredit = in.readString();
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
