package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 诉讼信息
 * Created by wangbin on 17/2/10.
 */
public class LawsuitMsgBean implements Parcelable {

    private String cardNo;
    private String caseNo;//案号
    private String caseStatus;// 案件状态
    private String companyId;
    private String court;
    private String id;
    private String lawsuitTitle;
    private String lawsuitType;
    private String name;//被执行人姓名
    private String registrineTime;// 立案时间
    private String releaseDate;//发布时间
    private String zxbd;//被执行标的



    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLawsuitTitle() {
        return lawsuitTitle;
    }

    public void setLawsuitTitle(String lawsuitTitle) {
        this.lawsuitTitle = lawsuitTitle;
    }

    public String getLawsuitType() {
        return lawsuitType;
    }

    public void setLawsuitType(String lawsuitType) {
        this.lawsuitType = lawsuitType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrineTime() {
        return registrineTime;
    }

    public void setRegistrineTime(String registrineTime) {
        this.registrineTime = registrineTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getZxbd() {
        return zxbd;
    }

    public void setZxbd(String zxbd) {
        this.zxbd = zxbd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cardNo);
        dest.writeString(this.caseNo);
        dest.writeString(this.caseStatus);
        dest.writeString(this.companyId);
        dest.writeString(this.court);
        dest.writeString(this.id);
        dest.writeString(this.lawsuitTitle);
        dest.writeString(this.lawsuitType);
        dest.writeString(this.name);
        dest.writeString(this.registrineTime);
        dest.writeString(this.releaseDate);
        dest.writeString(this.zxbd);
    }

    public LawsuitMsgBean() {
    }

    protected LawsuitMsgBean(Parcel in) {
        this.cardNo = in.readString();
        this.caseNo = in.readString();
        this.caseStatus = in.readString();
        this.companyId = in.readString();
        this.court = in.readString();
        this.id = in.readString();
        this.lawsuitTitle = in.readString();
        this.lawsuitType = in.readString();
        this.name = in.readString();
        this.registrineTime = in.readString();
        this.releaseDate = in.readString();
        this.zxbd = in.readString();
    }

    public static final Parcelable.Creator<LawsuitMsgBean> CREATOR = new Parcelable.Creator<LawsuitMsgBean>() {
        @Override
        public LawsuitMsgBean createFromParcel(Parcel source) {
            return new LawsuitMsgBean(source);
        }

        @Override
        public LawsuitMsgBean[] newArray(int size) {
            return new LawsuitMsgBean[size];
        }
    };
}
