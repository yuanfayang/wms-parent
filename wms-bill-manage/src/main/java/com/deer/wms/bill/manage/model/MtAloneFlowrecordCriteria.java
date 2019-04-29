package com.deer.wms.bill.manage.model;

import java.util.Date;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/12/10.
*/
public class MtAloneFlowrecordCriteria extends QueryCriteria {
	
	private String begDate;
	
	private String endDate;
	
	private String productName;
	
	private Integer flowrecordState;
	
	private String orderCode;
	
	private String deliveryOrderCode;
	
	private String returnOrderCode;
	
	
	
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReturnOrderCode() {
		return returnOrderCode;
	}

	public void setReturnOrderCode(String returnOrderCode) {
		this.returnOrderCode = returnOrderCode;
	}

	public String getDeliveryOrderCode() {
		return deliveryOrderCode;
	}

	public void setDeliveryOrderCode(String deliveryOrderCode) {
		this.deliveryOrderCode = deliveryOrderCode;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getFlowrecordState() {
		return flowrecordState;
	}

	public void setFlowrecordState(Integer flowrecordState) {
		this.flowrecordState = flowrecordState;
	}
	
	
}
