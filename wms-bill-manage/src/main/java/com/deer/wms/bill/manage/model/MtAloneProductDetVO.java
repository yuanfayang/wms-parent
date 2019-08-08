package com.deer.wms.bill.manage.model;

public class MtAloneProductDetVO extends MtAloneProductDet{
	
	private Float deliveryLength;

	private String productName;

	private String productCode;

	private String itemCode;

	private String proColorName;

	private String cellAlias;
	
//	MtAloneProductDet mtAloneProductDet;
//
//	public MtAloneProductDet getMtAloneProductDet() {
//		return mtAloneProductDet;
//	}
//
//	public void setMtAloneProductDet(MtAloneProductDet mtAloneProductDet) {
//		this.mtAloneProductDet = mtAloneProductDet;
//	}

	public Float getDeliveryLength() {
		return deliveryLength;
	}

	public void setDeliveryLength(Float deliveryLength) {
		this.deliveryLength = deliveryLength;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getProColorName() {
		return proColorName;
	}

	public void setProColorName(String proColorName) {
		this.proColorName = proColorName;
	}

	public String getCellAlias() {
		return cellAlias;
	}

	public void setCellAlias(String cellAlias) {
		this.cellAlias = cellAlias;
	}
}
