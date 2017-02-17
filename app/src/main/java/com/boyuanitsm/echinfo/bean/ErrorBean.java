package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 纠错错误实体
 * Created by Administrator on 2017/2/15.
 */

public class ErrorBean implements Parcelable{
    /**
     * "id":"4392f3ced30511e6b92ceca86ba4ba05",
     * "dictCode":"",
     * "dictName":"企业图谱",
     * "dictType":"correction_manage",
     * "dictDescribe":"纠错管理",
     * "isValid":null,
     * "icon":""
     */

    private String id;
    private String dictCode;
    private String dictName;
    private String dictType;
    private String dictDescribe;
    private String isValid;
    private String icon;

    private boolean isChecked;//是否被选中

    @Override
    public String toString() {
        return "ErrorBean{" +
                "id='" + id + '\'' +
                ", dictCode='" + dictCode + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictType='" + dictType + '\'' +
                ", dictDescribe='" + dictDescribe + '\'' +
                ", isValid='" + isValid + '\'' +
                ", icon='" + icon + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }

    protected ErrorBean(Parcel in) {
        id = in.readString();
        dictCode = in.readString();
        dictName = in.readString();
        dictType = in.readString();
        dictDescribe = in.readString();
        isValid = in.readString();
        icon = in.readString();
        isChecked = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(dictCode);
        dest.writeString(dictName);
        dest.writeString(dictType);
        dest.writeString(dictDescribe);
        dest.writeString(isValid);
        dest.writeString(icon);
        dest.writeByte((byte) (isChecked ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ErrorBean> CREATOR = new Creator<ErrorBean>() {
        @Override
        public ErrorBean createFromParcel(Parcel in) {
            return new ErrorBean(in);
        }

        @Override
        public ErrorBean[] newArray(int size) {
            return new ErrorBean[size];
        }
    };

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

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
