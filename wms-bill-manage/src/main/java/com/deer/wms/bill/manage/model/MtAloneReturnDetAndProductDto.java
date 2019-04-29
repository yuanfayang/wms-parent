package com.deer.wms.bill.manage.model;

import java.util.List;
/**
 * 将产品和产品的明细绑定为一个对象
 * @author ZTH
 *
 */
public class MtAloneReturnDetAndProductDto extends MtAloneProduct{
	
	List<MtAloneProductDet> returnOrderDetList;

	public List<MtAloneProductDet> getReturnOrderDetList() {
		return returnOrderDetList;
	}

	public void setReturnOrderDetList(List<MtAloneProductDet> returnOrderDetList) {
		this.returnOrderDetList = returnOrderDetList;
	}
	
	

}
