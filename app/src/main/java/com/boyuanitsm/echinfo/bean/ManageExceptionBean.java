package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 经营异常
 * Created by wangbin on 17/2/13.
 */
public class ManageExceptionBean implements Parcelable {

    private String companyId;
    private String id;
    private String insertCause;//列入原因
    private String insertOrg;//列入机关
    private String insertTime;//列入日期
    private String outCause;//移除原因
    private String outTime;//移除日期

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInsertCause() {
        return insertCause;
    }

    public void setInsertCause(String insertCause) {
        this.insertCause = insertCause;
    }

    public String getInsertOrg() {
        return insertOrg;
    }

    public void setInsertOrg(String insertOrg) {
        this.insertOrg = insertOrg;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getOutCause() {
        return outCause;
    }

    public void setOutCause(String outCause) {
        this.outCause = outCause;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyId);
        dest.writeString(this.id);
        dest.writeString(this.insertCause);
        dest.writeString(this.insertOrg);
        dest.writeString(this.insertTime);
        dest.writeString(this.outCause);
        dest.writeString(this.outTime);
    }

    public ManageExceptionBean() {
    }

    protected ManageExceptionBean(Parcel in) {
        this.companyId = in.readString();
        this.id = in.readString();
        this.insertCause = in.readString();
        this.insertOrg = in.readString();
        this.insertTime = in.readString();
        this.outCause = in.readString();
        this.outTime = in.readString();
    }

    public static final Parcelable.Creator<ManageExceptionBean> CREATOR = new Parcelable.Creator<ManageExceptionBean>() {
        @Override
        public ManageExceptionBean createFromParcel(Parcel source) {
            return new ManageExceptionBean(source);
        }

        @Override
        public ManageExceptionBean[] newArray(int size) {
            return new ManageExceptionBean[size];
        }
    };
}
