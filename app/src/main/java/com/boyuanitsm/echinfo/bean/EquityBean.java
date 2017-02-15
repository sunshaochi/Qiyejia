package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public class EquityBean implements Parcelable{
    private java.lang.String	account;

    private java.lang.String	companyId;

    private java.lang.String	date;

    private java.lang.String	id;

    private java.lang.String	pawnee;

    private java.lang.String	pawneeId;

    private java.lang.String	pledgor;

    private java.lang.String	pledgorId;

    private java.lang.String	registrationNumber;

    private java.lang.String	status;



    public EquityBean() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getPawnee() {
        return pawnee;
    }

    public void setPawnee(String pawnee) {
        this.pawnee = pawnee;
    }

    public String getPawneeId() {
        return pawneeId;
    }

    public void setPawneeId(String pawneeId) {
        this.pawneeId = pawneeId;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getPledgorId() {
        return pledgorId;
    }

    public void setPledgorId(String pledgorId) {
        this.pledgorId = pledgorId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    protected EquityBean(Parcel in) {
        account = in.readString();
        companyId = in.readString();
        date = in.readString();
        id = in.readString();
        pawnee = in.readString();
        pawneeId = in.readString();
        pledgor = in.readString();
        pledgorId = in.readString();
        registrationNumber = in.readString();
        status = in.readString();
    }

    public static final Creator<EquityBean> CREATOR = new Creator<EquityBean>() {
        @Override
        public EquityBean createFromParcel(Parcel in) {
            return new EquityBean(in);
        }

        @Override
        public EquityBean[] newArray(int size) {
            return new EquityBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(account);
        parcel.writeString(companyId);
        parcel.writeString(date);
        parcel.writeString(id);
        parcel.writeString(pawnee);
        parcel.writeString(pawneeId);
        parcel.writeString(pledgor);
        parcel.writeString(pledgorId);
        parcel.writeString(registrationNumber);
        parcel.writeString(status);
    }


}
