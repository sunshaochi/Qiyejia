package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 产品信息实体类
 * Q164454216
 * Created by xiaoke on 2017/2/16.
 */

public class ProductBean implements Parcelable{
    private   String	address;//    地址
    private int	capital;//    注册资本
    private   String	companyId;//    企业ID
    private   String	companyName;//    公司名
    private   String	createDate;//    创建时间
    private   String	domain;//    所属领域
    private   String	establishDate;//    成立时间
    private   String	id;//    主键ID
    private   String	industry;//    行业
    private   String	legalPerson;//    法人
    private   String	managementStatus;//    状态
    private   String	name;//    名称
    private   String	productPresentation;//    产品介绍
    private long	serialVersionUID;//
    private   String	tag;//    标签
    private   String	url;//    网址
    private   String	userReviews;//    用户点评

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
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

    public String getProductPresentation() {
        return productPresentation;
    }

    public void setProductPresentation(String productPresentation) {
        this.productPresentation = productPresentation;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(String userReviews) {
        this.userReviews = userReviews;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeInt(this.capital);
        dest.writeString(this.companyId);
        dest.writeString(this.companyName);
        dest.writeString(this.createDate);
        dest.writeString(this.domain);
        dest.writeString(this.establishDate);
        dest.writeString(this.id);
        dest.writeString(this.industry);
        dest.writeString(this.legalPerson);
        dest.writeString(this.managementStatus);
        dest.writeString(this.name);
        dest.writeString(this.productPresentation);
        dest.writeLong(this.serialVersionUID);
        dest.writeString(this.tag);
        dest.writeString(this.url);
        dest.writeString(this.userReviews);
    }

    public ProductBean() {
    }

    protected ProductBean(Parcel in) {
        this.address = in.readString();
        this.capital = in.readInt();
        this.companyId = in.readString();
        this.companyName = in.readString();
        this.createDate = in.readString();
        this.domain = in.readString();
        this.establishDate = in.readString();
        this.id = in.readString();
        this.industry = in.readString();
        this.legalPerson = in.readString();
        this.managementStatus = in.readString();
        this.name = in.readString();
        this.productPresentation = in.readString();
        this.serialVersionUID = in.readLong();
        this.tag = in.readString();
        this.url = in.readString();
        this.userReviews = in.readString();
    }

    public static final Creator<ProductBean> CREATOR = new Creator<ProductBean>() {
        @Override
        public ProductBean createFromParcel(Parcel source) {
            return new ProductBean(source);
        }

        @Override
        public ProductBean[] newArray(int size) {
            return new ProductBean[size];
        }
    };
}
