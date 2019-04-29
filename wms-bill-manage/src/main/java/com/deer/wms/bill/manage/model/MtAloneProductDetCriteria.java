package com.deer.wms.bill.manage.model;

import java.util.Date;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/11/24.
*/
public class MtAloneProductDetCriteria extends QueryCriteria {
	private String productBarcode;
	
	private String cellCode;
	//供应商编号
	private String supplierCode;
	//入库时间
	private Date warehouseEntryTime;
	//出库状态
	private String deliveryState;
	

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	/**
	 * @return the deliveryState
	 */
	public String getDeliveryState() {
		return deliveryState;
	}

	/**
	 * @param deliveryState the deliveryState to set
	 */
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public Date getWarehouseEntryTime() {
		return warehouseEntryTime;
	}

	public void setWarehouseEntryTime(Date warehouseEntryTime) {
		this.warehouseEntryTime = warehouseEntryTime;
	}

	public String getCellCode() {
		return cellCode;
	}

	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}
	
	
	
}
