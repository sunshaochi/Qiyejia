package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 股东
 * Created by wangbin on 17/2/9.
 */
public class StockMsgBean implements Parcelable {

    private String address;
    private String capital;//注册资本
    private String cardNo;//证件号码
    private String cardType;//证件类型
    private String companyId;//企业id
    private String companyName;
    private String createDate;
    private String datail;//详细
    private String establishDate;//成立时间
    private String id;
    private String legalPerson;//法人
    private String legalRepPersion;//法定代表人
    private String managementStatus;//状态
    private String name;//姓名/企业名称（股东）
    private String realSubcribe;//实缴出资
    private String realSubcribeTime;//实缴时间
    private String realSubcribeType;//实缴出资方式
    private String recordStatus;//登记状态
    private String serialVersionUID;
    private String stockType;//股东类型
    private String subcribe;//认缴出资
    private String subcribeType;//认缴出资方式


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDatail() {
        return datail;
    }

    public void setDatail(String datail) {
        this.datail = datail;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalRepPersion() {
        return legalRepPersion;
    }

    public void setLegalRepPersion(String legalRepPersion) {
        this.legalRepPersion = legalRepPersion;
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealSubcribe() {
        return realSubcribe;
    }

    public void setRealSubcribe(String realSubcribe) {
        this.realSubcribe = realSubcribe;
    }

    public String getRealSubcribeTime() {
        return realSubcribeTime;
    }

    public void setRealSubcribeTime(String realSubcribeTime) {
        this.realSubcribeTime = realSubcribeTime;
    }

    public String getRealSubcribeType() {
        return realSubcribeType;
    }

    public void setRealSubcribeType(String realSubcribeType) {
        this.realSubcribeType = realSubcribeType;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getSubcribe() {
        return subcribe;
    }

    public void setSubcribe(String subcribe) {
        this.subcribe = subcribe;
    }

    public String getSubcribeType() {
        return subcribeType;
    }

    public void setSubcribeType(String subcribeType) {
        this.subcribeType = subcribeType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.capital);
        dest.writeString(this.cardNo);
        dest.writeString(this.cardType);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.createDate);
        dest.writeString(this.datail);
        dest.writeString(this.establishDate);
        dest.writeString(this.id);
        dest.writeString(this.legalPerson);
        dest.writeString(this.legalRepPersion);
        dest.writeString(this.managementStatus);
        dest.writeString(this.name);
        dest.writeString(this.realSubcribe);
        dest.writeString(this.realSubcribeTime);
        dest.writeString(this.realSubcribeType);
        dest.writeString(this.recordStatus);
        dest.writeString(this.serialVersionUID);
        dest.writeString(this.stockType);
        dest.writeString(this.subcribe);
        dest.writeString(this.subcribeType);
    }

    public StockMsgBean() {
    }

    protected StockMsgBean(Parcel in) {
        this.address = in.readString();
        this.capital = in.readString();
        this.cardNo = in.readString();
        this.cardType = in.readString();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.createDate = in.readString();
        this.datail = in.readString();
        this.establishDate = in.readString();
        this.id = in.readString();
        this.legalPerson = in.readString();
        this.legalRepPersion = in.readString();
        this.managementStatus = in.readString();
        this.name = in.readString();
        this.realSubcribe = in.readString();
        this.realSubcribeTime = in.readString();
        this.realSubcribeType = in.readString();
        this.recordStatus = in.readString();
        this.serialVersionUID = in.readString();
        this.stockType = in.readString();
        this.subcribe = in.readString();
        this.subcribeType = in.readString();
    }

    public static final Parcelable.Creator<StockMsgBean> CREATOR = new Parcelable.Creator<StockMsgBean>() {
        @Override
        public StockMsgBean createFromParcel(Parcel source) {
            return new StockMsgBean(source);
        }

        @Override
        public StockMsgBean[] newArray(int size) {
            return new StockMsgBean[size];
        }
    };
}
