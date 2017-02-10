package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 行政处罚
 * Created by wangbin on 17/2/10.
 */
public class AdministrativePenaltyBean implements Parcelable {

    private String companyId;
    private String content;//处罚内容
    private String date;//决定日期
    private String decisionOrgan;//决定机关
    private String id;
    private String referenceNumber;//文号
    private String type;


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDecisionOrgan() {
        return decisionOrgan;
    }

    public void setDecisionOrgan(String decisionOrgan) {
        this.decisionOrgan = decisionOrgan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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
        dest.writeString(this.content);
        dest.writeString(this.date);
        dest.writeString(this.decisionOrgan);
        dest.writeString(this.id);
        dest.writeString(this.referenceNumber);
        dest.writeString(this.type);
    }

    public AdministrativePenaltyBean() {
    }

    protected AdministrativePenaltyBean(Parcel in) {
        this.companyId = in.readString();
        this.content = in.readString();
        this.date = in.readString();
        this.decisionOrgan = in.readString();
        this.id = in.readString();
        this.referenceNumber = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<AdministrativePenaltyBean> CREATOR = new Parcelable.Creator<AdministrativePenaltyBean>() {
        @Override
        public AdministrativePenaltyBean createFromParcel(Parcel source) {
            return new AdministrativePenaltyBean(source);
        }

        @Override
        public AdministrativePenaltyBean[] newArray(int size) {
            return new AdministrativePenaltyBean[size];
        }
    };
}
