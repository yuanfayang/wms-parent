package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class SupplierManageParams extends QueryParams{
    private Integer supplierId;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}
