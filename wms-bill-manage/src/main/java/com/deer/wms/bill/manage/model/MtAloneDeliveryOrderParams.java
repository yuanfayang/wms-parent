package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneDeliveryOrderParams extends QueryParams{
	
	private String productTypeCode;
	
	private String begDate;
	
	private String endDate;
	
	private String deliveryOrderCode;

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

	public String getBegDate() {
		return begDate;
	}

	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDeliveryOrderCode() {
		return deliveryOrderCode;
	}

	public void setDeliveryOrderCode(String deliveryOrderCode) {
		this.deliveryOrderCode = deliveryOrderCode;
	}
	
	

}
