package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  法院裁决
 * Created by wangbin on 17/2/10.
 */
public class CourtDecisionBean implements Parcelable {

    private String agent;//委托代理人
    private String announcementType;//公告类型
    private String appealParty;//上诉方
    private String caseNo;//案件编号
    private String clerk;//书记员
    private String companyId;
    private String content;//判决征文
    private String date;//判决日期
    private String defendant;//被诉方
    private String domicile;//住所递
    private String executeCourt;//执行单位
    private String id;
    private String legalRepresentative;//法定代表人
    private String peopleJury;//人民陪审员
    private String presidingJudge;//审判长
    private String serialVersionUID;
    private String status;//身份
    private String title;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(String announcementType) {
        this.announcementType = announcementType;
    }

    public String getAppealParty() {
        return appealParty;
    }

    public void setAppealParty(String appealParty) {
        this.appealParty = appealParty;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

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

    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getExecuteCourt() {
        return executeCourt;
    }

    public void setExecuteCourt(String executeCourt) {
        this.executeCourt = executeCourt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getPeopleJury() {
        return peopleJury;
    }

    public void setPeopleJury(String peopleJury) {
        this.peopleJury = peopleJury;
    }

    public String getPresidingJudge() {
        return presidingJudge;
    }

    public void setPresidingJudge(String presidingJudge) {
        this.presidingJudge = presidingJudge;
    }

    public String getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.agent);
        dest.writeString(this.announcementType);
        dest.writeString(this.appealParty);
        dest.writeString(this.caseNo);
        dest.writeString(this.clerk);
        dest.writeString(this.companyId);
        dest.writeString(this.content);
        dest.writeString(this.date);
        dest.writeString(this.defendant);
        dest.writeString(this.domicile);
        dest.writeString(this.executeCourt);
        dest.writeString(this.id);
        dest.writeString(this.legalRepresentative);
        dest.writeString(this.peopleJury);
        dest.writeString(this.presidingJudge);
        dest.writeString(this.serialVersionUID);
        dest.writeString(this.status);
        dest.writeString(this.title);
    }

    public CourtDecisionBean() {
    }

    protected CourtDecisionBean(Parcel in) {
        this.agent = in.readString();
        this.announcementType = in.readString();
        this.appealParty = in.readString();
        this.caseNo = in.readString();
        this.clerk = in.readString();
        this.companyId = in.readString();
        this.content = in.readString();
        this.date = in.readString();
        this.defendant = in.readString();
        this.domicile = in.readString();
        this.executeCourt = in.readString();
        this.id = in.readString();
        this.legalRepresentative = in.readString();
        this.peopleJury = in.readString();
        this.presidingJudge = in.readString();
        this.serialVersionUID = in.readString();
        this.status = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<CourtDecisionBean> CREATOR = new Parcelable.Creator<CourtDecisionBean>() {
        @Override
        public CourtDecisionBean createFromParcel(Parcel source) {
            return new CourtDecisionBean(source);
        }

        @Override
        public CourtDecisionBean[] newArray(int size) {
            return new CourtDecisionBean[size];
        }
    };
}
