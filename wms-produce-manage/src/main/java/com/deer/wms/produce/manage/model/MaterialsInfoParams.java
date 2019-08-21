package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by guo on 2019/07/18.
*/
public class MaterialsInfoParams extends QueryParams {
    /**
     * 开始时间
     */
    private String begDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 物料id
     */
    private Integer materialsId;

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

    public Integer getmaterialsId() {
        return materialsId;
    }

    public void setId(Integer materialsId) {
        this.materialsId = materialsId;
    }
}
