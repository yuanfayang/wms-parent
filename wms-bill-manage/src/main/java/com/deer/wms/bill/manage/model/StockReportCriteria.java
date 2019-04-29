package com.deer.wms.bill.manage.model;

import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.project.seed.core.service.QueryCriteria;

import java.util.Date;

public class StockReportCriteria extends QueryCriteria {

    private Date begDate;//起始时间

    private Date endDate;//结束时间

    private SupplierManage supplier;//供应商

    private String itemCode;//料号

    private String productName;//产品名称

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SupplierManage getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierManage supplier) {
        this.supplier = supplier;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
