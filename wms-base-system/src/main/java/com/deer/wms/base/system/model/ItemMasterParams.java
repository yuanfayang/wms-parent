package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class ItemMasterParams extends QueryParams{
    private Integer itemMasterId;

    public Integer getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }
}
