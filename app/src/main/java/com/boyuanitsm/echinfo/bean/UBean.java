package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangbin on 17/2/6.
 */
public class UBean implements Parcelable {
    private UserBean user;


    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
    }

    public UBean() {
    }

    protected UBean(Parcel in) {
        this.user = in.readParcelable(UserBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<UBean> CREATOR = new Parcelable.Creator<UBean>() {
        @Override
        public UBean createFromParcel(Parcel source) {
            return new UBean(source);
        }

        @Override
        public UBean[] newArray(int size) {
            return new UBean[size];
        }
    };
}
