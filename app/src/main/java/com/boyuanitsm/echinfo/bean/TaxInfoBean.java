package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 税务信用
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class TaxInfoBean implements Parcelable{
    private  String	balance;//    欠税余额
    private  String	companyId;//    企业ID
    private  String	evaluationUnit;//    评价单位
    private  String	evaluationYear;//    评价年度
    private  String	id;//    主键ID
    private  String	identifyNumber;//    纳税人识别号
    private  String	normalTax;//    是否正常纳税
    private  String	qualityRating;//    纳税信用等级
    private  String	whetherTaxes;//    是否欠税


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEvaluationUnit() {
        return evaluationUnit;
    }

    public void setEvaluationUnit(String evaluationUnit) {
        this.evaluationUnit = evaluationUnit;
    }

    public String getEvaluationYear() {
        return evaluationYear;
    }

    public void setEvaluationYear(String evaluationYear) {
        this.evaluationYear = evaluationYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getNormalTax() {
        return normalTax;
    }

    public void setNormalTax(String normalTax) {
        this.normalTax = normalTax;
    }

    public String getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(String qualityRating) {
        this.qualityRating = qualityRating;
    }

    public String getWhetherTaxes() {
        return whetherTaxes;
    }

    public void setWhetherTaxes(String whetherTaxes) {
        this.whetherTaxes = whetherTaxes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.balance);
        dest.writeString(this.companyId);
        dest.writeString(this.evaluationUnit);
        dest.writeString(this.evaluationYear);
        dest.writeString(this.id);
        dest.writeString(this.identifyNumber);
        dest.writeString(this.normalTax);
        dest.writeString(this.qualityRating);
        dest.writeString(this.whetherTaxes);
    }

    public TaxInfoBean() {
    }

    protected TaxInfoBean(Parcel in) {
        this.balance = in.readString();
        this.companyId = in.readString();
        this.evaluationUnit = in.readString();
        this.evaluationYear = in.readString();
        this.id = in.readString();
        this.identifyNumber = in.readString();
        this.normalTax = in.readString();
        this.qualityRating = in.readString();
        this.whetherTaxes = in.readString();
    }

    public static final Creator<TaxInfoBean> CREATOR = new Creator<TaxInfoBean>() {
        @Override
        public TaxInfoBean createFromParcel(Parcel source) {
            return new TaxInfoBean(source);
        }

        @Override
        public TaxInfoBean[] newArray(int size) {
            return new TaxInfoBean[size];
        }
    };
}
