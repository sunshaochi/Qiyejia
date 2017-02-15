package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 执行人
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public class ImplementBean implements Parcelable {
    private String accordingFile;//    执行依据文号
    private String companyId;//    企业ID
    private String companyName;//
    private String createDate;//
    private String duty;//       法律生效文书确定的义务
    private String establishDate;//       立案时间
    private String executeCourt;//       执行法院
    private String id;//       主键ID
    private String name;//       名称
    private String publishDate;//       公布时间
    private static long serialVersionUID;//
    private String status;//       被执行人的履行情况


    public String getAccordingFile() {
        return accordingFile;
    }

    public void setAccordingFile(String accordingFile) {
        this.accordingFile = accordingFile;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getExecuteCourt() {
        return executeCourt;
    }

    public void setExecuteCourt(String executeCourt) {
        this.executeCourt = executeCourt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        ImplementBean.serialVersionUID = serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accordingFile);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.createDate);
        dest.writeString(this.duty);
        dest.writeString(this.establishDate);
        dest.writeString(this.executeCourt);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.publishDate);
        dest.writeString(this.status);
    }

    public ImplementBean() {
    }

    protected ImplementBean(Parcel in) {
        this.accordingFile = in.readString();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.createDate = in.readString();
        this.duty = in.readString();
        this.establishDate = in.readString();
        this.executeCourt = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.publishDate = in.readString();
        this.status = in.readString();
    }

    public static final Creator<ImplementBean> CREATOR = new Creator<ImplementBean>() {
        @Override
        public ImplementBean createFromParcel(Parcel source) {
            return new ImplementBean(source);
        }

        @Override
        public ImplementBean[] newArray(int size) {
            return new ImplementBean[size];
        }
    };
}
