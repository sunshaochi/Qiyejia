package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 专利实体类
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class PatentBean implements Parcelable {

    private String id;//": "26eabad4c4e711e6883e00163e024b13",
    private String companyId;//": "企业ID'",
    private String serialNo;//": 序号,
    private String patenType;//": "专利类型",
    private String applicationNo;//": 申请号',
    private String releaseDate;//": "2016-01-21",
    private String content;//": 摘要,
    private String name;//": "专利名称",
    private String state;//": 状态,
    private String patentContent;//": 专利内容,
    private String publishedApplyNo;//": 申请公布号,
    private String publishedApplyDate;//": 申请公布日,
    private String inventor;//": 发明人
    private String patentAgency;//": 专利代理机构,
    private String applicatPerson;//": "申请人
    private String createDate;//": 状态


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatenType() {
        return patenType;
    }

    public void setPatenType(String patenType) {
        this.patenType = patenType;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPatentContent() {
        return patentContent;
    }

    public void setPatentContent(String patentContent) {
        this.patentContent = patentContent;
    }

    public String getPublishedApplyNo() {
        return publishedApplyNo;
    }

    public void setPublishedApplyNo(String publishedApplyNo) {
        this.publishedApplyNo = publishedApplyNo;
    }

    public String getPublishedApplyDate() {
        return publishedApplyDate;
    }

    public void setPublishedApplyDate(String publishedApplyDate) {
        this.publishedApplyDate = publishedApplyDate;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getPatentAgency() {
        return patentAgency;
    }

    public void setPatentAgency(String patentAgency) {
        this.patentAgency = patentAgency;
    }

    public String getApplicatPerson() {
        return applicatPerson;
    }

    public void setApplicatPerson(String applicatPerson) {
        this.applicatPerson = applicatPerson;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.companyId);
        dest.writeString(this.serialNo);
        dest.writeString(this.patenType);
        dest.writeString(this.applicationNo);
        dest.writeString(this.releaseDate);
        dest.writeString(this.content);
        dest.writeString(this.name);
        dest.writeString(this.state);
        dest.writeString(this.patentContent);
        dest.writeString(this.publishedApplyNo);
        dest.writeString(this.publishedApplyDate);
        dest.writeString(this.inventor);
        dest.writeString(this.patentAgency);
        dest.writeString(this.applicatPerson);
        dest.writeString(this.createDate);
    }

    public PatentBean() {
    }

    protected PatentBean(Parcel in) {
        this.id = in.readString();
        this.companyId = in.readString();
        this.serialNo = in.readString();
        this.patenType = in.readString();
        this.applicationNo = in.readString();
        this.releaseDate = in.readString();
        this.content = in.readString();
        this.name = in.readString();
        this.state = in.readString();
        this.patentContent = in.readString();
        this.publishedApplyNo = in.readString();
        this.publishedApplyDate = in.readString();
        this.inventor = in.readString();
        this.patentAgency = in.readString();
        this.applicatPerson = in.readString();
        this.createDate = in.readString();
    }

    public static final Parcelable.Creator<PatentBean> CREATOR = new Parcelable.Creator<PatentBean>() {
        @Override
        public PatentBean createFromParcel(Parcel source) {
            return new PatentBean(source);
        }

        @Override
        public PatentBean[] newArray(int size) {
            return new PatentBean[size];
        }
    };
}
