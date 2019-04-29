package com.deer.wms.bill.manage.model;

public class MtAloneDeliveryDetVO extends MtAloneDeliveryDet{
    private String supplierName;//供应商名称
    private String productCode;//品号
    private String itemCode;//料号
    private String productName;//产品名称
    private String colorName;//产品颜色
    private String rgbHex;//颜色编码
    private String cellCode;
    private Integer productDetIndex;
    private Float productDetLength=(float) 0;
    private Float productDetRemainLength=(float) 0;
    private Float detectLength=(float) 0;
    
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
	public Float getProductDetLength() {
		return productDetLength;
	}
	public void setProductDetLength(Float productDetLength) {
		this.productDetLength = productDetLength;
	}
	public Float getProductDetRemainLength() {
		return productDetRemainLength;
	}
	public void setProductDetRemainLength(Float productDetRemainLength) {
		this.productDetRemainLength = productDetRemainLength;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getCellCode() {
		return cellCode;
	}
	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}
	public Float getDetectLength() {
		return detectLength;
	}
	public void setDetectLength(Float detectLength) {
		this.detectLength = detectLength;
	}
	public String getRgbHex() {
		return rgbHex;
	}
	public void setRgbHex(String rgbHex) {
		this.rgbHex = rgbHex;
	}

	
}
