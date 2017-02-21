package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 专利接收类
 * Q164454216
 * Created by xiaoke on 2017/2/17.
 */
public class PatenInfoDataBean implements Parcelable{
    private List<PatenInfomationBean> rows;
    private int total;


    public List<PatenInfomationBean> getRows() {
        return rows;
    }

    public void setRows(List<PatenInfomationBean> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.rows);
        dest.writeInt(this.total);
    }

    public PatenInfoDataBean() {
    }

    protected PatenInfoDataBean(Parcel in) {
        this.rows = in.createTypedArrayList(PatenInfomationBean.CREATOR);
        this.total = in.readInt();
    }

    public static final Creator<PatenInfoDataBean> CREATOR = new Creator<PatenInfoDataBean>() {
        @Override
        public PatenInfoDataBean createFromParcel(Parcel source) {
            return new PatenInfoDataBean(source);
        }

        @Override
        public PatenInfoDataBean[] newArray(int size) {
            return new PatenInfoDataBean[size];
        }
    };
}
