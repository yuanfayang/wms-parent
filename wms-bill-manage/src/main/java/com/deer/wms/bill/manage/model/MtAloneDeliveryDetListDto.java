package com.deer.wms.bill.manage.model;

import java.util.List;

public class MtAloneDeliveryDetListDto {
	MtAloneDeliveryOrder mtAloneDeliveryOrder;

	public MtAloneDeliveryOrder getMtAloneDeliveryOrder() {
		return mtAloneDeliveryOrder;
	}

	public void setMtAloneDeliveryOrder(MtAloneDeliveryOrder mtAloneDeliveryOrder) { this.mtAloneDeliveryOrder = mtAloneDeliveryOrder; }


	List<MtAloneProductDetVO> deliveryOrderDetVOList;

	public List<MtAloneProductDetVO> getDeliveryOrderDetVOList() {
		return deliveryOrderDetVOList;
	}

	public void setDeliveryOrderDetVOList(List<MtAloneProductDetVO> deliveryOrderDetVOList) { this.deliveryOrderDetVOList = deliveryOrderDetVOList; }

}
