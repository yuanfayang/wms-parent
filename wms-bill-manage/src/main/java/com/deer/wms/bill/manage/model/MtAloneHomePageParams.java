package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MtAloneHomePageParams extends QueryParams{
    private int timeType;//时间类型 1：本周，2：上周，3：本月，4.上月

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date begDate;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date endDate;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date currentDate;

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    private String productTypeCode;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }
}
