package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 抽查检查
 * Created by wangbin on 17/2/13.
 */
public class SpotCheckBean implements Parcelable {

    private String companyId;
    private String date;
    private String id;
    private String implementingAgency;//检查实施机关
    private String result;
    private String type;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImplementingAgency() {
        return implementingAgency;
    }

    public void setImplementingAgency(String implementingAgency) {
        this.implementingAgency = implementingAgency;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyId);
        dest.writeString(this.date);
        dest.writeString(this.id);
        dest.writeString(this.implementingAgency);
        dest.writeString(this.result);
        dest.writeString(this.type);
    }

    public SpotCheckBean() {
    }

    protected SpotCheckBean(Parcel in) {
        this.companyId = in.readString();
        this.date = in.readString();
        this.id = in.readString();
        this.implementingAgency = in.readString();
        this.result = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<SpotCheckBean> CREATOR = new Parcelable.Creator<SpotCheckBean>() {
        @Override
        public SpotCheckBean createFromParcel(Parcel source) {
            return new SpotCheckBean(source);
        }

        @Override
        public SpotCheckBean[] newArray(int size) {
            return new SpotCheckBean[size];
        }
    };
}
