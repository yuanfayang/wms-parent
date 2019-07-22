package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by gtt on 2019/07/18.
*/
public class MtAloneInboundOrderParams extends QueryParams {

    /**
     * 开始时间
     */
    private String begDate;

    /**
     * 结束时间
     */
    private String endDate;

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
