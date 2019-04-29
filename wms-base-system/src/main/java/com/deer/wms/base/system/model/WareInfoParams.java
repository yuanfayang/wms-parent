package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class WareInfoParams extends QueryParams{

    private String wareCode;

    private Integer wareId;

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
    }


}
