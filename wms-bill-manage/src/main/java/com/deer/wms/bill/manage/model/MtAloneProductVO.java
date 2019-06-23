package com.deer.wms.bill.manage.model;

public class MtAloneProductVO extends MtAloneProduct{
	
	Integer rollNum=0;
	
	Float deliveryLength=(float) 0;
	
	Float detectLength=(float) 0;
	
	Float remainLength=(float) 0;
	
	String supplierName=null;

	String itemTypeName=null;

	String itemVarietyName = null;

    public String getItemVarietyName() {
        return itemVarietyName;
    }

    public void setItemVarietyName(String itemVarietyName) {
        this.itemVarietyName = itemVarietyName;
    }

    private String purchaser;

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public Integer getRollNum() {
		return rollNum;
	}

	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}

	public Float getDeliveryLength() {
		return deliveryLength;
	}

	public void setDeliveryLength(Float deliveryLength) {
		this.deliveryLength = deliveryLength;
	}

	public Float getDetectLength() {
		return detectLength;
	}

	public void setDetectLength(Float detectLength) {
		this.detectLength = detectLength;
	}

	public Float getRemainLength() {
		return remainLength;
	}

	public void setRemainLength(Float remainLength) {
		this.remainLength = remainLength;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
}
