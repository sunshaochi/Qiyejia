package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public class RecruiBean implements Parcelable {
    private String address;

    private String	comeFrom;

    private String	companyId;

    private String	education;

    private String id;

    private String jobName;

    private String monthlyPay;

    private String	recuiteNumber;

    private String	releaseDate;

    private String	workSuffer;

    public RecruiBean() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(String monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public String getRecuiteNumber() {
        return recuiteNumber;
    }

    public void setRecuiteNumber(String recuiteNumber) {
        this.recuiteNumber = recuiteNumber;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWorkSuffer() {
        return workSuffer;
    }

    public void setWorkSuffer(String workSuffer) {
        this.workSuffer = workSuffer;
    }

    protected RecruiBean(Parcel in) {
        address = in.readString();
        comeFrom = in.readString();
        companyId = in.readString();
        education = in.readString();
        id = in.readString();
        jobName = in.readString();
        monthlyPay = in.readString();
        recuiteNumber = in.readString();
        releaseDate = in.readString();
        workSuffer = in.readString();
    }

    public static final Creator<RecruiBean> CREATOR = new Creator<RecruiBean>() {
        @Override
        public RecruiBean createFromParcel(Parcel in) {
            return new RecruiBean(in);
        }

        @Override
        public RecruiBean[] newArray(int size) {
            return new RecruiBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(address);
        parcel.writeString(comeFrom);
        parcel.writeString(companyId);
        parcel.writeString(education);
        parcel.writeString(id);
        parcel.writeString(jobName);
        parcel.writeString(monthlyPay);
        parcel.writeString(recuiteNumber);
        parcel.writeString(releaseDate);
        parcel.writeString(workSuffer);
    }
}
