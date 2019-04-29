package com.deer.wms.bill.manage.model;

import java.util.Date;

import com.deer.wms.project.seed.core.service.QueryParams;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MtAloneDeliveryParams extends QueryParams{
	
	private String productBarCode;

    private String begDate;
    private String endDate;
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
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
    

}
