package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 变更记录
 * Created by wangbin on 17/2/22.
 */
public class EditRecordBean implements Parcelable {
    private String afterEdit;//修改后
    private String beforeEdit;//修改前
    private String companyId;//企业id
    private String editTime;//变更时间
    private String editType;//变更类型(法人变更、经营范围变更等)
    private String id;

    public String getAfterEdit() {
        return afterEdit;
    }

    public void setAfterEdit(String afterEdit) {
        this.afterEdit = afterEdit;
    }

    public String getBeforeEdit() {
        return beforeEdit;
    }

    public void setBeforeEdit(String beforeEdit) {
        this.beforeEdit = beforeEdit;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.afterEdit);
        dest.writeString(this.beforeEdit);
        dest.writeString(this.companyId);
        dest.writeString(this.editTime);
        dest.writeString(this.editType);
        dest.writeString(this.id);
    }

    public EditRecordBean() {
    }

    protected EditRecordBean(Parcel in) {
        this.afterEdit = in.readString();
        this.beforeEdit = in.readString();
        this.companyId = in.readString();
        this.editTime = in.readString();
        this.editType = in.readString();
        this.id = in.readString();
    }

    public static final Parcelable.Creator<EditRecordBean> CREATOR = new Parcelable.Creator<EditRecordBean>() {
        @Override
        public EditRecordBean createFromParcel(Parcel source) {
            return new EditRecordBean(source);
        }

        @Override
        public EditRecordBean[] newArray(int size) {
            return new EditRecordBean[size];
        }
    };
}
