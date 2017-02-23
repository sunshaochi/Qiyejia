package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 对外投资
 * Created by bitch-1 on 2017/2/13.
 */
public class EnterpriBean implements Parcelable {
    private String	companyId;

    private String	companyName;

    private String	content;

    private String	id;

    private String	newsFrom;

    private String	newsName;

    private String	newsTime;

    private String	title;

    private String	url;

    public EnterpriBean() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsFrom() {
        return newsFrom;
    }

    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected EnterpriBean(Parcel in) {
        companyId = in.readString();
        companyName = in.readString();
        content = in.readString();
        id = in.readString();
        newsFrom = in.readString();
        newsName = in.readString();
        newsTime = in.readString();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<EnterpriBean> CREATOR = new Creator<EnterpriBean>() {
        @Override
        public EnterpriBean createFromParcel(Parcel in) {
            return new EnterpriBean(in);
        }

        @Override
        public EnterpriBean[] newArray(int size) {
            return new EnterpriBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(companyId);
        parcel.writeString(companyName);
        parcel.writeString(content);
        parcel.writeString(id);
        parcel.writeString(newsFrom);
        parcel.writeString(newsName);
        parcel.writeString(newsTime);
        parcel.writeString(title);
        parcel.writeString(url);
    }
}
