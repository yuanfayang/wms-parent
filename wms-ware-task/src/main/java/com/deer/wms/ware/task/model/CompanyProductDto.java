package com.deer.wms.ware.task.model;

public class CompanyProductDto {

	private String productName;   //产品名称
	private String productDetCode;		//产品编号
	private String productDetBarCode;		//产品明细条形码
	private float productDetRemainLength;		//米数
	private String productColorName;		//颜色
	private String areaName;		//货区
	private String shelfName;		//货架
	private String cellCode;		//货位
	private String cellName;
	private String inventoryCode;		//盘点单号
	private Integer wareId;			//仓库id
	private String wareName;		//仓库名称
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetCode() {
		return productDetCode;
	}
	public void setProductDetCode(String productDetCode) {
		this.productDetCode = productDetCode;
	}
	public String getProductDetBarCode() {
		return productDetBarCode;
	}
	public void setProductDetBarCode(String productDetBarCode) {
		this.productDetBarCode = productDetBarCode;
	}
	public float getProductDetRemainLength() {
		return productDetRemainLength;
	}
	public void setProductDetRemainLength(float productDetRemainLength) {
		this.productDetRemainLength = productDetRemainLength;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
	public String getCellCode() {
		return cellCode;
	}
	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}
	public String getProductColorName() {
		return productColorName;
	}
	public void setProductColorName(String productColorName) {
		this.productColorName = productColorName;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public Integer getWareId() {
		return wareId;
	}
	public void setWareId(Integer wareId) {
		this.wareId = wareId;
	}
	public String getWareName() {
		return wareName;
	}
	public void setWareName(String wareName) {
		this.wareName = wareName;
	}
	
}
