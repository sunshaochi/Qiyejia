package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 分支机构
 * Created by wangbin on 17/2/23.
 */
public class SonEnterpriseBean  implements Parcelable {

    private String affiliatesUrl;//分支机构Url
    private String approvedDate;//核准日期
    private String businessTerm;//营业期限
    private String companyId;//企业id
    private String companyName;//企业名称
    private String companyType;//企业类型
    private String creditCode;//统一社会信用代码
    private String fatherCompanyId;//父企业id
    private String foundingDate;//成立时间
    private String id;
    private String industry;//行业
    private String legalRepPersion;//企业法人
    private String recordStatus;//登记状态
    private String registerCode;//组织机构代码
    private String registeredCapital;//注册资本
    private String registerId;//工商注册号
    private String registerPlace;//登记机关
    private String status;//状态
    private String organizationCode;//组织机构代码

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getAffiliatesUrl() {
        return affiliatesUrl;
    }

    public void setAffiliatesUrl(String affiliatesUrl) {
        this.affiliatesUrl = affiliatesUrl;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(String businessTerm) {
        this.businessTerm = businessTerm;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getFatherCompanyId() {
        return fatherCompanyId;
    }

    public void setFatherCompanyId(String fatherCompanyId) {
        this.fatherCompanyId = fatherCompanyId;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLegalRepPersion() {
        return legalRepPersion;
    }

    public void setLegalRepPersion(String legalRepPersion) {
        this.legalRepPersion = legalRepPersion;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getRegisterPlace() {
        return registerPlace;
    }

    public void setRegisterPlace(String registerPlace) {
        this.registerPlace = registerPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SonEnterpriseBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.affiliatesUrl);
        dest.writeString(this.approvedDate);
        dest.writeString(this.businessTerm);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.companyType);
        dest.writeString(this.creditCode);
        dest.writeString(this.fatherCompanyId);
        dest.writeString(this.foundingDate);
        dest.writeString(this.id);
        dest.writeString(this.industry);
        dest.writeString(this.legalRepPersion);
        dest.writeString(this.recordStatus);
        dest.writeString(this.registerCode);
        dest.writeString(this.registeredCapital);
        dest.writeString(this.registerId);
        dest.writeString(this.registerPlace);
        dest.writeString(this.status);
        dest.writeString(this.organizationCode);
    }

    protected SonEnterpriseBean(Parcel in) {
        this.affiliatesUrl = in.readString();
        this.approvedDate = in.readString();
        this.businessTerm = in.readString();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.companyType = in.readString();
        this.creditCode = in.readString();
        this.fatherCompanyId = in.readString();
        this.foundingDate = in.readString();
        this.id = in.readString();
        this.industry = in.readString();
        this.legalRepPersion = in.readString();
        this.recordStatus = in.readString();
        this.registerCode = in.readString();
        this.registeredCapital = in.readString();
        this.registerId = in.readString();
        this.registerPlace = in.readString();
        this.status = in.readString();
        this.organizationCode = in.readString();
    }

    public static final Creator<SonEnterpriseBean> CREATOR = new Creator<SonEnterpriseBean>() {
        @Override
        public SonEnterpriseBean createFromParcel(Parcel source) {
            return new SonEnterpriseBean(source);
        }

        @Override
        public SonEnterpriseBean[] newArray(int size) {
            return new SonEnterpriseBean[size];
        }
    };
}
