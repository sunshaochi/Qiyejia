package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 专利接收类
 * Q164454216
 * Created by xiaoke on 2017/2/17.
 */

public class PatenDataBean implements Parcelable{
    private PatenInfoDataBean patenInfomationList;
    private List<String> releaseYear;

    public PatenInfoDataBean getPatenInfomationList() {
        return patenInfomationList;
    }

    public void setPatenInfomationList(PatenInfoDataBean patenInfomationList) {
        this.patenInfomationList = patenInfomationList;
    }

    public List<String> getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(List<String> releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.patenInfomationList, flags);
        dest.writeStringList(this.releaseYear);
    }

    public PatenDataBean() {
    }

    protected PatenDataBean(Parcel in) {
        this.patenInfomationList = in.readParcelable(PatenInfoDataBean.class.getClassLoader());
        this.releaseYear = in.createStringArrayList();
    }

    public static final Creator<PatenDataBean> CREATOR = new Creator<PatenDataBean>() {
        @Override
        public PatenDataBean createFromParcel(Parcel source) {
            return new PatenDataBean(source);
        }

        @Override
        public PatenDataBean[] newArray(int size) {
            return new PatenDataBean[size];
        }
    };
}
