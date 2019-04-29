package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class UnitParams extends QueryParams{
    private Integer unitId;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
