package com.deer.wms.produce.manage.model;


/**
 * @Author: weihongyang
 * @Date: 2019/9/9 15:22
 * @Version 1.0
 */
public class MtAloneStockProductVo extends MtAloneStockProduct{
    /**
     * 物料类型名称
     */
    private String itemTypeName;

    /**
     * 物料品种名称
     */
    private String itemVarietyName;

    /**
     * 采购员名字
     */
    private String purchaserName;

    /**
     *销售员名字
     */
    private String sellerName;

    /**
     * 供应商代号
     */
    private String supplierCodeName;

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getItemVarietyName() {
        return itemVarietyName;
    }

    public void setItemVarietyName(String itemVarietyName) {
        this.itemVarietyName = itemVarietyName;
    }

    @Override
    public String getPurchaserName() {
        return purchaserName;
    }

    @Override
    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    @Override
    public String getSellerName() {
        return sellerName;
    }

    @Override
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSupplierCodeName() {
        return supplierCodeName;
    }

    public void setSupplierCodeName(String supplierCodeName) {
        this.supplierCodeName = supplierCodeName;
    }
}
