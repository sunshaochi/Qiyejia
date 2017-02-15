package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bitch-1 on 2017/2/14.
 */

public class ClearinfoBean implements Parcelable {
    private String	companyId;
//    企业ID
    private String	id;
//    主键ID
    private String	mainPerson;
//    主要人员
    private String	person;
    //    成员


    public ClearinfoBean() {
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainPerson() {
        return mainPerson;
    }

    public void setMainPerson(String mainPerson) {
        this.mainPerson = mainPerson;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    protected ClearinfoBean(Parcel in) {
        companyId = in.readString();
        id = in.readString();
        mainPerson = in.readString();
        person = in.readString();
    }

    public static final Creator<ClearinfoBean> CREATOR = new Creator<ClearinfoBean>() {
        @Override
        public ClearinfoBean createFromParcel(Parcel in) {
            return new ClearinfoBean(in);
        }

        @Override
        public ClearinfoBean[] newArray(int size) {
            return new ClearinfoBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(companyId);
        parcel.writeString(id);
        parcel.writeString(mainPerson);
        parcel.writeString(person);
    }

}
