package com.deer.wms.bill.manage.model;

/*
 * 为了一览表上端8个属性做的结构，包含8个参数
 */

public class MtAloneProductDetView extends MtAloneProductDet{
	
	private int inventoryDet;//产品库存

	private int forReviewPro;//待审核

	private int allDeliveryDet;//所有出库
	
	private int detectedDet;//已检测,暂为0
	
	private int forOnShelfDet;//待上架
	
	private int onShelfDet;//已上架
	
	private int forDetecteDet;//待检测,暂为0

	private int deliveryedDet;//已出库

	/**
	 * @return the inventoryDet
	 */
	public int getInventoryDet() {
		return inventoryDet;
	}

	/**
	 * @param inventoryDet the inventoryDet to set
	 */
	public void setInventoryDet(int inventoryDet) {
		this.inventoryDet = inventoryDet;
	}

	/**
	 * @return the forReviewPro
	 */
	public int getForReviewPro() {
		return forReviewPro;
	}

	/**
	 * @param forReviewPro the forReviewPro to set
	 */
	public void setForReviewPro(int forReviewPro) {
		this.forReviewPro = forReviewPro;
	}

	/**
	 * @return the allDeliveryDet
	 */
	public int getAllDeliveryDet() {
		return allDeliveryDet;
	}

	/**
	 * @param allDeliveryDet the allDeliveryDet to set
	 */
	public void setAllDeliveryDet(int allDeliveryDet) {
		this.allDeliveryDet = allDeliveryDet;
	}

	/**
	 * @return the detectedDet
	 */
	public int getDetectedDet() {
		return detectedDet;
	}

	/**
	 * @param detectedDet the detectedDet to set
	 */
	public void setDetectedDet(int detectedDet) {
		this.detectedDet = detectedDet;
	}

	/**
	 * @return the forOnShelfDet
	 */
	public int getForOnShelfDet() {
		return forOnShelfDet;
	}

	/**
	 * @param forOnShelfDet the forOnShelfDet to set
	 */
	public void setForOnShelfDet(int forOnShelfDet) {
		this.forOnShelfDet = forOnShelfDet;
	}


	/**
	 * @return the onShelfDet
	 */
	public int getOnShelfDet() {
		return onShelfDet;
	}

	/**
	 * @param onShelfDet the onShelfDet to set
	 */
	public void setOnShelfDet(int onShelfDet) {
		this.onShelfDet = onShelfDet;
	}

	/**
	 * @return the forDetecteDet
	 */
	public int getForDetecteDet() {
		return forDetecteDet;
	}

	/**
	 * @param forDetecteDet the forDetecteDet to set
	 */
	public void setForDetecteDet(int forDetecteDet) {
		this.forDetecteDet = forDetecteDet;
	}

	/**
	 * @return the deliveryedDet
	 */
	public int getDeliveryedDet() {
		return deliveryedDet;
	}

	/**
	 * @param deliveryedDet the deliveryedDet to set
	 */
	public void setDeliveryedDet(int deliveryedDet) {
		this.deliveryedDet = deliveryedDet;
	}


}
