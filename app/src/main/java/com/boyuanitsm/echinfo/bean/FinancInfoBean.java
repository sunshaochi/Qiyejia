package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bitch-1 on 2017/2/15.
 */
public class FinancInfoBean implements Parcelable {
    private String	account;
//    融资金额
    private String	companyId;
//    企业ID
    private String	date;
//    日期
    private String	id;
//    主键ID
    private String	invests;
//    投资人
    private String	reason;
    //    融资描述

    public FinancInfoBean() {
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

    public String getInvests() {
        return invests;
    }

    public void setInvests(String invests) {
        this.invests = invests;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    protected FinancInfoBean(Parcel in) {
        account = in.readString();
        companyId = in.readString();
        date = in.readString();
        id = in.readString();
        invests = in.readString();
        reason = in.readString();
    }

    public static final Creator<FinancInfoBean> CREATOR = new Creator<FinancInfoBean>() {
        @Override
        public FinancInfoBean createFromParcel(Parcel in) {
            return new FinancInfoBean(in);
        }

        @Override
        public FinancInfoBean[] newArray(int size) {
            return new FinancInfoBean[size];
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
        parcel.writeString(invests);
        parcel.writeString(reason);
    }


}
