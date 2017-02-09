package com.boyuanitsm.echinfo.bean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/8.
 */

public class DateBean<T> {
    private int total;
    private List<T> rows;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTatal() {
        return total;
    }

    public void setTatal(int tatal) {
        this.total = tatal;
    }
}
