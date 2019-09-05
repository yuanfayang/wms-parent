package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/7/21 18:08
 * @Version 1.0
 *
 * 物料基础信息，集成库存、公司、供应商、单位等信息
 *
 */


public class MaterialsInfoDto extends MaterialsInfo{
    private String positionName;
    private Float quantity;
    private String companyName;
    private String unitName;
    private String parentName;
    private String supplierName;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
