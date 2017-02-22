package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bitch-1 on 2017/2/22.
 */

public class WebsiteBean implements Parcelable{

    /**
     * id : e2
     * webName : 测试网站
     * webAddress :
     * companyId : 123456789
     * type :
     * companyName :
     * checkTime :
     * publishNo :
     * status :
     * ortNature :
     * address :
     * managementStatus :
     * industry :
     * legalPerson :
     * establishDate :
     * regCapital :
     */

    private String id;
    private String webName;
    private String webAddress;
    private String companyId;
    private String type;
    private String companyName;
    private String checkTime;
    private String publishNo;
    private String status;
    private String ortNature;
    private String address;
    private String managementStatus;
    private String industry;
    private String legalPerson;
    private String establishDate;
    private String regCapital;

    protected WebsiteBean(Parcel in) {
        id = in.readString();
        webName = in.readString();
        webAddress = in.readString();
        companyId = in.readString();
        type = in.readString();
        companyName = in.readString();
        checkTime = in.readString();
        publishNo = in.readString();
        status = in.readString();
        ortNature = in.readString();
        address = in.readString();
        managementStatus = in.readString();
        industry = in.readString();
        legalPerson = in.readString();
        establishDate = in.readString();
        regCapital = in.readString();
    }

    public static final Creator<WebsiteBean> CREATOR = new Creator<WebsiteBean>() {
        @Override
        public WebsiteBean createFromParcel(Parcel in) {
            return new WebsiteBean(in);
        }

        @Override
        public WebsiteBean[] newArray(int size) {
            return new WebsiteBean[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPublishNo() {
        return publishNo;
    }

    public void setPublishNo(String publishNo) {
        this.publishNo = publishNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrtNature() {
        return ortNature;
    }

    public void setOrtNature(String ortNature) {
        this.ortNature = ortNature;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(webName);
        parcel.writeString(webAddress);
        parcel.writeString(companyId);
        parcel.writeString(type);
        parcel.writeString(companyName);
        parcel.writeString(checkTime);
        parcel.writeString(publishNo);
        parcel.writeString(status);
        parcel.writeString(ortNature);
        parcel.writeString(address);
        parcel.writeString(managementStatus);
        parcel.writeString(industry);
        parcel.writeString(legalPerson);
        parcel.writeString(establishDate);
        parcel.writeString(regCapital);
    }

    public WebsiteBean() {
    }
}
