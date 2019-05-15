package com.deer.wms.ware.task.model;

import com.deer.wms.project.seed.core.service.QueryParams;
/**
 * 该类是从库存盘点前端获取数据的类
 * @author 魏红阳
 *
 */
public class InventoryInfoCriteria extends QueryParams{

	private String inventoryCode;
	private Integer inventoryStatus;
    private String workStartTime;
    private String workEndTime;
    private String itemTypeName;
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public Integer getInventoryStatus() {
		return inventoryStatus;
	}
	public void setInventoryStatus(Integer inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	public String getWorkStartTime() {
		return workStartTime;
	}
	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}
	public String getWorkEndTime() {
		return workEndTime;
	}
	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
    
	
}
