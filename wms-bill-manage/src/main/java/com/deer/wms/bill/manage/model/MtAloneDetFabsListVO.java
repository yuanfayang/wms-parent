package com.deer.wms.bill.manage.model;

import java.util.ArrayList;

public class MtAloneDetFabsListVO extends MtAloneProductDet{


    private String productCode;//品号

    private String productName;//产品名称

    private String cellAlias;//货位别名

    private String supplierName;//供应商名称

    private String itemCode;//料号

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    private Integer total=999;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCellAlias() {
        return cellAlias;
    }

    public void setCellAlias(String cellAlias) {
        this.cellAlias = cellAlias;
    }

    private ArrayList<MtAloneExaminationDetails>fabricList=new ArrayList<MtAloneExaminationDetails>();

    public ArrayList<MtAloneExaminationDetails> getFabricList() {
        return fabricList;
    }

    public void setFabricList(ArrayList<MtAloneExaminationDetails> fabricList) {
        this.fabricList = fabricList;
    }
}