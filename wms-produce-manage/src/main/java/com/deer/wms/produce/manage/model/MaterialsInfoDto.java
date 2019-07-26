package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/7/21 18:08
 * @Version 1.0
 *
 * 物料基础信息，集成库存、公司等信息
 *
 */


public class MaterialsInfoDto extends MaterialsInfo{
    private String positionName;
    private String quantity;
    private String companyName;
    private String unitName;
    private String parentName;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
}
