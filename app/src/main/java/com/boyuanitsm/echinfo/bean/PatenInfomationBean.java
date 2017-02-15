package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 专利
 * Created by wangbin on 17/2/13.
 */
public class PatenInfomationBean implements Parcelable {

    private String applicationNo;//申请号
    private String applicatPerson;//申请人
    private String companyId;
    private String content;// 摘要
    private String createDate;
    private String id;
    private String inventor;//发明人
    private String name;//专利名称
    private String patentAgency;//专利代理机构
    private String patentContent;//专利内容
    private String patenType;//专利类型
    private String publishedApplyDate;//申请公布日
    private String publishedApplyNo;//申请公布号
    private String releaseDate;//公布日期
    private String serialNo;//序号
    private String state;//状态

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getApplicatPerson() {
        return applicatPerson;
    }

    public void setApplicatPerson(String applicatPerson) {
        this.applicatPerson = applicatPerson;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatentAgency() {
        return patentAgency;
    }

    public void setPatentAgency(String patentAgency) {
        this.patentAgency = patentAgency;
    }

    public String getPatentContent() {
        return patentContent;
    }

    public void setPatentContent(String patentContent) {
        this.patentContent = patentContent;
    }

    public String getPatenType() {
        return patenType;
    }

    public void setPatenType(String patenType) {
        this.patenType = patenType;
    }

    public String getPublishedApplyDate() {
        return publishedApplyDate;
    }

    public void setPublishedApplyDate(String publishedApplyDate) {
        this.publishedApplyDate = publishedApplyDate;
    }

    public String getPublishedApplyNo() {
        return publishedApplyNo;
    }

    public void setPublishedApplyNo(String publishedApplyNo) {
        this.publishedApplyNo = publishedApplyNo;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.applicationNo);
        dest.writeString(this.applicatPerson);
        dest.writeString(this.companyId);
        dest.writeString(this.content);
        dest.writeString(this.createDate);
        dest.writeString(this.id);
        dest.writeString(this.inventor);
        dest.writeString(this.name);
        dest.writeString(this.patentAgency);
        dest.writeString(this.patentContent);
        dest.writeString(this.patenType);
        dest.writeString(this.publishedApplyDate);
        dest.writeString(this.publishedApplyNo);
        dest.writeString(this.releaseDate);
        dest.writeString(this.serialNo);
        dest.writeString(this.state);
    }

    public PatenInfomationBean() {
    }

    protected PatenInfomationBean(Parcel in) {
        this.applicationNo = in.readString();
        this.applicatPerson = in.readString();
        this.companyId = in.readString();
        this.content = in.readString();
        this.createDate = in.readString();
        this.id = in.readString();
        this.inventor = in.readString();
        this.name = in.readString();
        this.patentAgency = in.readString();
        this.patentContent = in.readString();
        this.patenType = in.readString();
        this.publishedApplyDate = in.readString();
        this.publishedApplyNo = in.readString();
        this.releaseDate = in.readString();
        this.serialNo = in.readString();
        this.state = in.readString();
    }

    public static final Parcelable.Creator<PatenInfomationBean> CREATOR = new Parcelable.Creator<PatenInfomationBean>() {
        @Override
        public PatenInfomationBean createFromParcel(Parcel source) {
            return new PatenInfomationBean(source);
        }

        @Override
        public PatenInfomationBean[] newArray(int size) {
            return new PatenInfomationBean[size];
        }
    };
}
