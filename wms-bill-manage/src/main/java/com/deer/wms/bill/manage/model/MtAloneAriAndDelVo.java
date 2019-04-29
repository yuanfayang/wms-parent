package com.deer.wms.bill.manage.model;

import java.util.Date;

public class MtAloneAriAndDelVo {

    private Date date;

    private Double milesSum;//入库、出库米数统计

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMilesSum() {
        return milesSum;
    }

    public void setMilesSum(Double milesSum) {
        this.milesSum = milesSum;
    }
}
