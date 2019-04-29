package com.deer.wms.bill.manage.model;

public class MtAloneDetectDetVO extends MtAloneDetectDet{
	
    private String supplierName;//供应商名称
    private String productCode;//品号
    private String itemCode;//料号
    private String productName;//产品名称
    private Integer productDetIndex;
    
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public Integer getProductDetIndex() {
		return productDetIndex;
	}
	public void setProductDetIndex(Integer productDetIndex) {
		this.productDetIndex = productDetIndex;
	}
    
    

}
