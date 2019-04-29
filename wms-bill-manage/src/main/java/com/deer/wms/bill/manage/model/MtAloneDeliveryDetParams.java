package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneDeliveryDetParams extends QueryParams{
     String deliveryOrderCode;

	public String getDeliveryOrderCode() {
		return deliveryOrderCode;
	}

	public void setDeliveryOrderCode(String deliveryOrderCode) {
		this.deliveryOrderCode = deliveryOrderCode;
	}
     
}
