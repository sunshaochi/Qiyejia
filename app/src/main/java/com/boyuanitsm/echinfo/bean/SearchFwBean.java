package com.boyuanitsm.echinfo.bean;

/**
 * 公司范围条件筛选
 * Q164454216
 * Created by xiaoke on 2017/2/16.
 */

public class SearchFwBean {
//    公司名称:screeningRange = 0;
//    产品:screeningRange = 7;
//    股东、法人、高管:screeningRange = 8;
//    经营范围:screeningRange = 9;
//    联系方式:screeningRange = 10;
//    网址:screeningRange = 11
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
