package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 接收失信实体类
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public class LoseCreditDatabean  implements Parcelable{
    private LoseCreditRowsBean CourtUnit;
    private LoseCreditRowsBean CourtPerson;


    public LoseCreditRowsBean getCourtUnit() {
        return CourtUnit;
    }

    public void setCourtUnit(LoseCreditRowsBean courtUnit) {
        CourtUnit = courtUnit;
    }

    public LoseCreditRowsBean getCourtPerson() {
        return CourtPerson;
    }

    public void setCourtPerson(LoseCreditRowsBean courtPerson) {
        CourtPerson = courtPerson;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.CourtUnit, flags);
        dest.writeParcelable(this.CourtPerson, flags);
    }

    public LoseCreditDatabean() {
    }

    protected LoseCreditDatabean(Parcel in) {
        this.CourtUnit = in.readParcelable(LoseCreditRowsBean.class.getClassLoader());
        this.CourtPerson = in.readParcelable(LoseCreditRowsBean.class.getClassLoader());
    }

    public static final Creator<LoseCreditDatabean> CREATOR = new Creator<LoseCreditDatabean>() {
        @Override
        public LoseCreditDatabean createFromParcel(Parcel source) {
            return new LoseCreditDatabean(source);
        }

        @Override
        public LoseCreditDatabean[] newArray(int size) {
            return new LoseCreditDatabean[size];
        }
    };
}
