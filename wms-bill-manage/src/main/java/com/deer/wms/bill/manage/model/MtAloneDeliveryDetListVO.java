package com.deer.wms.bill.manage.model;

public class MtAloneDeliveryDetListVO extends MtAloneDeliveryDet{
	/*
	 * 产品料号，来自产品表
	 */
	private String cellCode;
	/*
	 * 产品料号，来自仓位表
	 */
	private String cellAlias;
	/*
	 * 产品料号，来自产品表
	 */
	private String itemCode;
	/*
	 * 产品名字，来自产品表
	 */
	private String productName;
	/*
	 * 产品品号，来自产品表
	 */
	private String productCode;
	/*
	 * 产品规格，来自产品表
	 */
	private String specification;
	/*
	 *明细原长，来自检测表
	 */
	private Float detectLength;
	public String getCellCode() {
		return cellCode;
	}
	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public Float getDetectLength() {
		return detectLength;
	}
	public void setDetectLength(Float detectLength) {
		this.detectLength = detectLength;
	}


	public String getCellAlias() {
		return cellAlias;
	}

	public void setCellAlias(String cellAlias) {
		this.cellAlias = cellAlias;
	}
}
