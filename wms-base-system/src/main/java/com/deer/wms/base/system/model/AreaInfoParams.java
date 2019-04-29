package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class AreaInfoParams extends QueryParams{

    private String wareCode;

    private String areaCode;

    private Integer areaId;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }
}
