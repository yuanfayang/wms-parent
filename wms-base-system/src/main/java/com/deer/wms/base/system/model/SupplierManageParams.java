package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.List;

public class SupplierManageParams extends QueryParams{
    private Integer supplierId;

    private List<String> headersName;

    public List<String> getHeadersName() {
        return headersName;
    }

    public void setHeadersName(List<String> headersName) {
        this.headersName = headersName;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}
