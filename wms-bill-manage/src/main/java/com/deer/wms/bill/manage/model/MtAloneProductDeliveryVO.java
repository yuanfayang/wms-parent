package com.deer.wms.bill.manage.model;

import java.util.Date;

public class MtAloneProductDeliveryVO extends MtAloneProduct{
	
	Float deliveryLength=(float) 0;

	Date delTime;

	public Date getDelTime() {
		return delTime;
	}

	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	public Float getDeliveryLength() {
		return deliveryLength;
	}

	public void setDeliveryLength(Float deliveryLength) {
		this.deliveryLength = deliveryLength;
	}
	

}
