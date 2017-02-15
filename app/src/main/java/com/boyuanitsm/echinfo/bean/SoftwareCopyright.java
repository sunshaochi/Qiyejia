package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 软件著作权
 * Created by wangbin on 17/2/14.
 */
public class SoftwareCopyright implements Parcelable {

    private String casRn;//登记号
    private String casRnCheckDate;//登记批准日
    private String companyId;
    private String companyName;
    private String copyrightOwner;//著作权人
    private String createDate;
    private String finishCreateDate;//创作完成日期
    private String firstReleaseDate;//首次发布日期
    private String id;
    private String serialNo;// 序号
    private String softwareBookName;//软件名称
    private String softwareTsp;//软件简称
    private String type;//类型
    private String typeNo;//分类号
    private String versionNo;//版本号


    public String getCasRn() {
        return casRn;
    }

    public void setCasRn(String casRn) {
        this.casRn = casRn;
    }

    public String getCasRnCheckDate() {
        return casRnCheckDate;
    }

    public void setCasRnCheckDate(String casRnCheckDate) {
        this.casRnCheckDate = casRnCheckDate;
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

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner;
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

    public String getSoftwareBookName() {
        return softwareBookName;
    }

    public void setSoftwareBookName(String softwareBookName) {
        this.softwareBookName = softwareBookName;
    }

    public String getSoftwareTsp() {
        return softwareTsp;
    }

    public void setSoftwareTsp(String softwareTsp) {
        this.softwareTsp = softwareTsp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.casRn);
        dest.writeString(this.casRnCheckDate);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.copyrightOwner);
        dest.writeString(this.createDate);
        dest.writeString(this.finishCreateDate);
        dest.writeString(this.firstReleaseDate);
        dest.writeString(this.id);
        dest.writeString(this.serialNo);
        dest.writeString(this.softwareBookName);
        dest.writeString(this.softwareTsp);
        dest.writeString(this.type);
        dest.writeString(this.typeNo);
        dest.writeString(this.versionNo);
    }

    public SoftwareCopyright() {
    }

    protected SoftwareCopyright(Parcel in) {
        this.casRn = in.readString();
        this.casRnCheckDate = in.readString();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.copyrightOwner = in.readString();
        this.createDate = in.readString();
        this.finishCreateDate = in.readString();
        this.firstReleaseDate = in.readString();
        this.id = in.readString();
        this.serialNo = in.readString();
        this.softwareBookName = in.readString();
        this.softwareTsp = in.readString();
        this.type = in.readString();
        this.typeNo = in.readString();
        this.versionNo = in.readString();
    }

    public static final Parcelable.Creator<SoftwareCopyright> CREATOR = new Parcelable.Creator<SoftwareCopyright>() {
        @Override
        public SoftwareCopyright createFromParcel(Parcel source) {
            return new SoftwareCopyright(source);
        }

        @Override
        public SoftwareCopyright[] newArray(int size) {
            return new SoftwareCopyright[size];
        }
    };
}
