package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 企业证书bean
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class QiYeZsBean implements Parcelable {
    private String companyId;//": "123456789",
    private String remark;//": "测试资质认证",
    private String id;//": "y3",
    private String certificateNo;//": null, '证书编号',
    private String releaseCertificateDate;//": null,发证日期',
    private String serialNo;//": null,序号',
    private String certificateType;//": null'证书类型',

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getReleaseCertificateDate() {
        return releaseCertificateDate;
    }

    public void setReleaseCertificateDate(String releaseCertificateDate) {
        this.releaseCertificateDate = releaseCertificateDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyId);
        dest.writeString(this.remark);
        dest.writeString(this.id);
        dest.writeString(this.certificateNo);
        dest.writeString(this.releaseCertificateDate);
        dest.writeString(this.serialNo);
        dest.writeString(this.certificateType);
    }

    public QiYeZsBean() {
    }

    protected QiYeZsBean(Parcel in) {
        this.companyId = in.readString();
        this.remark = in.readString();
        this.id = in.readString();
        this.certificateNo = in.readString();
        this.releaseCertificateDate = in.readString();
        this.serialNo = in.readString();
        this.certificateType = in.readString();
    }

    public static final Creator<QiYeZsBean> CREATOR = new Creator<QiYeZsBean>() {
        @Override
        public QiYeZsBean createFromParcel(Parcel source) {
            return new QiYeZsBean(source);
        }

        @Override
        public QiYeZsBean[] newArray(int size) {
            return new QiYeZsBean[size];
        }
    };
}
