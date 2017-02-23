package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 公司范围条件筛选
 * Q164454216
 * Created by xiaoke on 2017/2/16.
 */

public class SearchFwBean implements Parcelable{
//    公司名称:screeningRange = 0;
//    产品:screeningRange = 7;
//    股东、法人、高管:screeningRange = 8;
//    经营范围:screeningRange = 9;
//    联系方式:screeningRange = 10;
//    网址:screeningRange = 11
    private int num;
    private String name;

    public SearchFwBean(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.num);
        dest.writeString(this.name);
    }

    public SearchFwBean() {
    }

    protected SearchFwBean(Parcel in) {
        this.num = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<SearchFwBean> CREATOR = new Creator<SearchFwBean>() {
        @Override
        public SearchFwBean createFromParcel(Parcel source) {
            return new SearchFwBean(source);
        }

        @Override
        public SearchFwBean[] newArray(int size) {
            return new SearchFwBean[size];
        }
    };
}
