package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 原创著作权
 * Created by wangbin on 17/2/13.
 */
public class CopyrightsBean implements Parcelable {

    private String	casRn;
   // varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登记号',
    private String	casRnDate;
    //varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登记日期',
    private String	companyId;
//    varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '企业ID',
    private String	companyName;
    private String	createDate;
    private String	finishCreateDate;
//    varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创作完成日期',
    private String	firstReleaseDate;
//    varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '首次发布日期',
    private String	id;
//    varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
    private String	serialNo;
//    varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '序号',
    private String	type;
//    varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类别',
    private String	worksName;
//    varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '作品名称',



    public String getCasRn() {
        return casRn;
    }

    public void setCasRn(String casRn) {
        this.casRn = casRn;
    }

    public String getCasRnDate() {
        return casRnDate;
    }

    public void setCasRnDate(String casRnDate) {
        this.casRnDate = casRnDate;
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

    public String getFinishCreateDate() {
        return finishCreateDate;
    }

    public void setFinishCreateDate(String finishCreateDate) {
        this.finishCreateDate = finishCreateDate;
    }

    public String getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(String firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.casRn);
        dest.writeString(this.casRnDate);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.createDate);
        dest.writeString(this.finishCreateDate);
        dest.writeString(this.firstReleaseDate);
        dest.writeString(this.id);
        dest.writeString(this.serialNo);
        dest.writeString(this.type);
        dest.writeString(this.worksName);
    }

    public CopyrightsBean() {
    }

    protected CopyrightsBean(Parcel in) {
        this.casRn = in.readString();
        this.casRnDate = in.readString();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.createDate = in.readString();
        this.finishCreateDate = in.readString();
        this.firstReleaseDate = in.readString();
        this.id = in.readString();
        this.serialNo = in.readString();
        this.type = in.readString();
        this.worksName = in.readString();
    }

    public static final Parcelable.Creator<CopyrightsBean> CREATOR = new Parcelable.Creator<CopyrightsBean>() {
        @Override
        public CopyrightsBean createFromParcel(Parcel source) {
            return new CopyrightsBean(source);
        }

        @Override
        public CopyrightsBean[] newArray(int size) {
            return new CopyrightsBean[size];
        }
    };
}
