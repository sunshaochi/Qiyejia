package com.boyuanitsm.echinfo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 失信实体类
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public class LoseCreditBean implements Parcelable{

    private  long serialVersionUID ;

    /**
     *  生效法律文书确定的义务
     */
    private String duty;

    /**
     *  同PARTYTYPENAME
     */
    private String sType;

    /**
     *  做出执行依据单位
     */
    private String gistunit;

    /**
     *  被执行人姓名/名称
     */
    private String iname;

    /**
     *  URL
     */
    private String url;

    /**
     *  失信被执行人行为具体情形
     */
    private String disrupttypename;

    /**
     *  年龄
     */
    private Long age;

    /**
     *  案号
     */
    private String casecode;

    /**
     *  立案时间
     */
    private String regdate;

    /**
     *  发布时间
     */
    private String publishdate;

    /**
     *  个人/对公客户，580表示自然人，581表示企业或其他组织
     */
    private String partytypename;

    /**
     *  执行法院
     */
    private String courtname;

    /**
     *  身份证号/组织机构代码
     */
    private String cardnum;

    /**
     *  key,源网站给该数据的唯一标识
     */
    private String key;

    /**
     *  性别
     */
    private String sexy;

    /**
     *  关注次数
     */
    private Long focusnumber;

    /**
     *  被执行人的履行情况
     */
    private String performance;

    /**
     *
     */
    private String sId;

    /**
     *  执行依据文号
     */
    private String gistid;

    /**
     *  省份
     */
    private String areaname;

    /**
     *  是否存在黑名单中
     */
    private String isBlacklist;

    /**
     *  录入时间
     */

    private String buildTime;
    private String bTime;

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public static Creator<LoseCreditBean> getCREATOR() {
        return CREATOR;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getGistunit() {
        return gistunit;
    }

    public void setGistunit(String gistunit) {
        this.gistunit = gistunit;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisrupttypename() {
        return disrupttypename;
    }

    public void setDisrupttypename(String disrupttypename) {
        this.disrupttypename = disrupttypename;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public String getPartytypename() {
        return partytypename;
    }

    public void setPartytypename(String partytypename) {
        this.partytypename = partytypename;
    }

    public String getCourtname() {
        return courtname;
    }

    public void setCourtname(String courtname) {
        this.courtname = courtname;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public Long getFocusnumber() {
        return focusnumber;
    }

    public void setFocusnumber(Long focusnumber) {
        this.focusnumber = focusnumber;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getGistid() {
        return gistid;
    }

    public void setGistid(String gistid) {
        this.gistid = gistid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(String isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public LoseCreditBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.serialVersionUID);
        dest.writeString(this.duty);
        dest.writeString(this.sType);
        dest.writeString(this.gistunit);
        dest.writeString(this.iname);
        dest.writeString(this.url);
        dest.writeString(this.disrupttypename);
        dest.writeValue(this.age);
        dest.writeString(this.casecode);
        dest.writeString(this.regdate);
        dest.writeString(this.publishdate);
        dest.writeString(this.partytypename);
        dest.writeString(this.courtname);
        dest.writeString(this.cardnum);
        dest.writeString(this.key);
        dest.writeString(this.sexy);
        dest.writeValue(this.focusnumber);
        dest.writeString(this.performance);
        dest.writeString(this.sId);
        dest.writeString(this.gistid);
        dest.writeString(this.areaname);
        dest.writeString(this.isBlacklist);
        dest.writeString(this.buildTime);
        dest.writeString(this.bTime);
    }

    protected LoseCreditBean(Parcel in) {
        this.serialVersionUID = in.readLong();
        this.duty = in.readString();
        this.sType = in.readString();
        this.gistunit = in.readString();
        this.iname = in.readString();
        this.url = in.readString();
        this.disrupttypename = in.readString();
        this.age = (Long) in.readValue(Long.class.getClassLoader());
        this.casecode = in.readString();
        this.regdate = in.readString();
        this.publishdate = in.readString();
        this.partytypename = in.readString();
        this.courtname = in.readString();
        this.cardnum = in.readString();
        this.key = in.readString();
        this.sexy = in.readString();
        this.focusnumber = (Long) in.readValue(Long.class.getClassLoader());
        this.performance = in.readString();
        this.sId = in.readString();
        this.gistid = in.readString();
        this.areaname = in.readString();
        this.isBlacklist = in.readString();
        this.buildTime = in.readString();
        this.bTime = in.readString();
    }

    public static final Creator<LoseCreditBean> CREATOR = new Creator<LoseCreditBean>() {
        @Override
        public LoseCreditBean createFromParcel(Parcel source) {
            return new LoseCreditBean(source);
        }

        @Override
        public LoseCreditBean[] newArray(int size) {
            return new LoseCreditBean[size];
        }
    };
}
