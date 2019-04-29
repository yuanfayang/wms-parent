package com.deer.wms.ware.task.model;

import com.deer.wms.project.seed.core.service.QueryParams;
/**
 * 该类是从新增盘点前端获取到的数据类
 * @author 魏红阳
 *
 */
public class CompanyProductCriteria extends QueryParams{

	private Integer wareId;
	private Integer areaId;
	private Integer shelfId;
	private Integer itemTypeId;
	public Integer getWareId() {
		return wareId;
	}
	public void setWareId(Integer wareId) {
		this.wareId = wareId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getShelfId() {
		return shelfId;
	}
	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}
	public Integer getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(Integer itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	
}
