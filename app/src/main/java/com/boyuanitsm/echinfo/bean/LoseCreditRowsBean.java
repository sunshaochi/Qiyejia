package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 获取失信内容
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public class LoseCreditRowsBean implements Parcelable {
    private int total;
    private List<LoseCreditBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<LoseCreditBean> getRows() {
        return rows;
    }

    public void setRows(List<LoseCreditBean> rows) {
        this.rows = rows;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeTypedList(this.rows);
    }

    public LoseCreditRowsBean() {
    }

    protected LoseCreditRowsBean(Parcel in) {
        this.total = in.readInt();
        this.rows = in.createTypedArrayList(LoseCreditBean.CREATOR);
    }

    public static final Creator<LoseCreditRowsBean> CREATOR = new Creator<LoseCreditRowsBean>() {
        @Override
        public LoseCreditRowsBean createFromParcel(Parcel source) {
            return new LoseCreditRowsBean(source);
        }

        @Override
        public LoseCreditRowsBean[] newArray(int size) {
            return new LoseCreditRowsBean[size];
        }
    };
}
