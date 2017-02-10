package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 法院公告
 * Created by wangbin on 17/2/10.
 */
public class CourtAnnoBean implements Parcelable {

    private String companyId;
    private String content;//正文
    private String court;
    private String date;
    private String id;
    private String person;
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

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
        dest.writeString(this.court);
        dest.writeString(this.date);
        dest.writeString(this.id);
        dest.writeString(this.person);
        dest.writeString(this.type);
    }

    public CourtAnnoBean() {
    }

    protected CourtAnnoBean(Parcel in) {
        this.companyId = in.readString();
        this.content = in.readString();
        this.court = in.readString();
        this.date = in.readString();
        this.id = in.readString();
        this.person = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<CourtAnnoBean> CREATOR = new Parcelable.Creator<CourtAnnoBean>() {
        @Override
        public CourtAnnoBean createFromParcel(Parcel source) {
            return new CourtAnnoBean(source);
        }

        @Override
        public CourtAnnoBean[] newArray(int size) {
            return new CourtAnnoBean[size];
        }
    };
}
