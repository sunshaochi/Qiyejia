package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 专利类型
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class PatentTypeBean implements Parcelable {
    private String id;//": "54958a4dedca11e6b92ceca86ba4ba05",
    private String dictCode;//": "",
    private String dictName;//": "外观设计",
    private String dictType;//": "paten_type_key",
    private String dictDescribe;//": "专利类型",
    private String isValid;//": null,
    private String icon;//": ""

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictDescribe() {
        return dictDescribe;
    }

    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.dictCode);
        dest.writeString(this.dictName);
        dest.writeString(this.dictType);
        dest.writeString(this.dictDescribe);
        dest.writeString(this.isValid);
        dest.writeString(this.icon);
    }

    public PatentTypeBean() {
    }

    protected PatentTypeBean(Parcel in) {
        this.id = in.readString();
        this.dictCode = in.readString();
        this.dictName = in.readString();
        this.dictType = in.readString();
        this.dictDescribe = in.readString();
        this.isValid = in.readString();
        this.icon = in.readString();
    }

    public static final Creator<PatentTypeBean> CREATOR = new Creator<PatentTypeBean>() {
        @Override
        public PatentTypeBean createFromParcel(Parcel source) {
            return new PatentTypeBean(source);
        }

        @Override
        public PatentTypeBean[] newArray(int size) {
            return new PatentTypeBean[size];
        }
    };
}
