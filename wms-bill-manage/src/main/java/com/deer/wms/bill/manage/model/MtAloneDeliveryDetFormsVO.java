package com.deer.wms.bill.manage.model;

public class MtAloneDeliveryDetFormsVO extends MtAloneDeliveryDet{
	private Float productPrice=(float) 0;
	private String clientName;
	private String clientAddress;
	private String trackingNumber;
	private String expressCompanyName;
	private Float expressFee=(float) 0;
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getExpressCompanyName() {
		return expressCompanyName;
	}
	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}
	public Float getExpressFee() {
		return expressFee;
	}
	public void setExpressFee(Float expressFee) {
		this.expressFee = expressFee;
	}
	
	

}
