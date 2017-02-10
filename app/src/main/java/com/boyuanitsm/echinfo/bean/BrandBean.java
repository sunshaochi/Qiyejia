package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 商标实体类
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public class BrandBean implements Parcelable {
    private String	agent;//    DEFAULT NULL COMMENT '商标代理机构'
    private String	applicatPerson;//    DEFAULT NULL COMMENT '申请人'
    private String	applicatTime;//    DEFAULT NULL COMMENT '申请日期'
    private   String	companyId;//    varchar(32) 企业id
    private   String	createDate;//    创建时间
    private   String	dynamic;//    DEFAULT NULL COMMENT '商标动态'
    private   String	icon;//    DEFAULT NULL COMMENT '图标'
    private   String	id;//    NOT NULL COMMENT '主键ID'
    private   String	name;//    DEFAULT NULL COMMENT '商标名称'
    private   String	registerNo;//    DEFAULT NULL COMMENT '注册号'
//    private static long	serialVersionUID;//
    private   String	serviceItems;//    DEFAULT NULL COMMENT '商品及服务列表'
    private   String	status;//    DEFAULT NULL COMMENT '商标状态'
    private   String	type;//    DEFAULT NULL COMMENT '所属类别'
    private   String	url;//    DEFAULT NULL COMMENT '连接'
    private   String	useTime;//    DEFAULT NULL COMMENT '商标使用年限'



    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getApplicatPerson() {
        return applicatPerson;
    }

    public void setApplicatPerson(String applicatPerson) {
        this.applicatPerson = applicatPerson;
    }

    public String getApplicatTime() {
        return applicatTime;
    }

    public void setApplicatTime(String applicatTime) {
        this.applicatTime = applicatTime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getServiceItems() {
        return serviceItems;
    }

    public void setServiceItems(String serviceItems) {
        this.serviceItems = serviceItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.agent);
        dest.writeString(this.applicatPerson);
        dest.writeString(this.applicatTime);
        dest.writeString(this.companyId);
        dest.writeString(this.createDate);
        dest.writeString(this.dynamic);
        dest.writeString(this.icon);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.registerNo);
        dest.writeString(this.serviceItems);
        dest.writeString(this.status);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeString(this.useTime);
    }

    public BrandBean() {
    }

    protected BrandBean(Parcel in) {
        this.agent = in.readString();
        this.applicatPerson = in.readString();
        this.applicatTime = in.readString();
        this.companyId = in.readString();
        this.createDate = in.readString();
        this.dynamic = in.readString();
        this.icon = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.registerNo = in.readString();
        this.serviceItems = in.readString();
        this.status = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.useTime = in.readString();
    }

    public static final Creator<BrandBean> CREATOR = new Creator<BrandBean>() {
        @Override
        public BrandBean createFromParcel(Parcel source) {
            return new BrandBean(source);
        }

        @Override
        public BrandBean[] newArray(int size) {
            return new BrandBean[size];
        }
    };
}
