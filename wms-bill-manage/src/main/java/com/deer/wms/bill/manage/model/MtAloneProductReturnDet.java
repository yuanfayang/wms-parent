package com.deer.wms.bill.manage.model;

public class MtAloneProductReturnDet extends MtAloneProductDet{
	//0表示不是删除，1表示删除
	private Integer isDelete;
	//0表示不是新增明细，1表示是新增
	private Integer isNewCreate;
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getIsNewCreate() {
		return isNewCreate;
	}
	public void setIsNewCreate(Integer isNewCreate) {
		this.isNewCreate = isNewCreate;
	}
	
	

}
