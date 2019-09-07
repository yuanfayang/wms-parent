package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by hy on 2019/07/19.
*/
public class ProductProcessParams extends QueryParams {
    /**
     * 开始时间
     */
    private String begDate;

    /**
     * 计划完工时间
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
