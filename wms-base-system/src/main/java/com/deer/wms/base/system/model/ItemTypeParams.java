package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class ItemTypeParams extends QueryParams{
    private Integer itemTypeId;

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }
}
