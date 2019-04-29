package com.deer.wms.bill.manage.model;

import java.util.List;

/**
 * 将产品和产品的明细绑定为一个对象，出库的时候有可能同时出几个产品
 * @author ZTH
 *
 */
public class MtAloneDeliveryDetAndProductDto {
	
//	MtAloneProduct mtAloneProduct;
	
	List<MtAloneProductDetVO> deliveryOrderDetVOList;

//	public MtAloneProduct getMtAloneProduct() {
//		return mtAloneProduct;
//	}
//
//	public void setMtAloneProduct(MtAloneProduct mtAloneProduct) {
//		this.mtAloneProduct = mtAloneProduct;
//	}

	public List<MtAloneProductDetVO> getDeliveryOrderDetVOList() {
		return deliveryOrderDetVOList;
	}

	public void setDeliveryOrderDetVOList(List<MtAloneProductDetVO> deliveryOrderDetVOList) {
		this.deliveryOrderDetVOList = deliveryOrderDetVOList;
	}

}
