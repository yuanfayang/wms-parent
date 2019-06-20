package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class ItemTypeParams extends QueryParams{
    private Integer itemTypeId;

    private Integer varietyTypeId;

    public Integer getVarietyTypeId() {
        return varietyTypeId;
    }

    public void setVarietyTypeId(Integer varietyTypeId) {
        this.varietyTypeId = varietyTypeId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

}
