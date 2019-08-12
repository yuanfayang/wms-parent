package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneDetectDetParams extends QueryParams{
	private String deliveryOrderCode;

	/**
	 * 开始时间
	 */
	private String begDate;

	/**
	 * 结束时间
	 */
	private String endDate;

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
}
