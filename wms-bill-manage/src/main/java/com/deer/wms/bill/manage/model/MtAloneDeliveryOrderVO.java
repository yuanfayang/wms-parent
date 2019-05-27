package com.deer.wms.bill.manage.model;

public class MtAloneDeliveryOrderVO extends MtAloneDeliveryOrder{
	
	Float deliveryLength=(float) 0;
	private String salesperson;

	public Float getDeliveryLength() {
		return deliveryLength;
	}

	public void setDeliveryLength(Float deliveryLength) {
		this.deliveryLength = deliveryLength;
	}


	public String getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
}
