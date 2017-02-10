package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 年报
 * Created by wangbin on 17/2/9.
 */
public class YearReportBean implements Parcelable {
    private String companyId;
    private String companyName;
    private String id;
    private String name;
    private String year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.year);
    }

    public YearReportBean() {
    }

    protected YearReportBean(Parcel in) {
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.year = in.readString();
    }

    public static final Parcelable.Creator<YearReportBean> CREATOR = new Parcelable.Creator<YearReportBean>() {
        @Override
        public YearReportBean createFromParcel(Parcel source) {
            return new YearReportBean(source);
        }

        @Override
        public YearReportBean[] newArray(int size) {
            return new YearReportBean[size];
        }
    };
}
