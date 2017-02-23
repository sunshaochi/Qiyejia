package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 主要成员
 * Created by wangbin on 17/2/23.
 */
public class MainMemberBean implements Parcelable {

    private String companyId;
    private String companyName;//企业名称
    private String id;
    private String  jobName;//职位名称
    private String persionName; //成员名称
    private String share;//所占公司股份分额

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getPersionName() {
        return persionName;
    }

    public void setPersionName(String persionName) {
        this.persionName = persionName;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
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
        dest.writeString(this.jobName);
        dest.writeString(this.persionName);
        dest.writeString(this.share);
    }

    public MainMemberBean() {
    }

    protected MainMemberBean(Parcel in) {
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.id = in.readString();
        this.jobName = in.readString();
        this.persionName = in.readString();
        this.share = in.readString();
    }

    public static final Parcelable.Creator<MainMemberBean> CREATOR = new Parcelable.Creator<MainMemberBean>() {
        @Override
        public MainMemberBean createFromParcel(Parcel source) {
            return new MainMemberBean(source);
        }

        @Override
        public MainMemberBean[] newArray(int size) {
            return new MainMemberBean[size];
        }
    };
}
