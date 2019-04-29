package com.deer.wms.bill.manage.model;

import java.util.List;
/**
 * 该类包含了退货单、产品及对应明细的对象
 * @author ZTH
 *
 */
public class MtAloneReturnDetListDto {
	MtAloneReturnOrder mtAloneReturnOrder;
	
	List<MtAloneProductDet> returnOrderDetList;
	
	List<MtAloneProductReturnDet> returnDetList;

	public MtAloneReturnOrder getMtAloneReturnOrder() {
		return mtAloneReturnOrder;
	}

	public void setMtAloneReturnOrder(MtAloneReturnOrder mtAloneReturnOrder) {
		this.mtAloneReturnOrder = mtAloneReturnOrder;
	}

	public List<MtAloneProductDet> getReturnOrderDetList() {
		return returnOrderDetList;
	}

	public void setReturnOrderDetList(List<MtAloneProductDet> returnOrderDetList) {
		this.returnOrderDetList = returnOrderDetList;
	}

	public List<MtAloneProductReturnDet> getReturnDetList() {
		return returnDetList;
	}

	public void setReturnDetList(List<MtAloneProductReturnDet> returnDetList) {
		this.returnDetList = returnDetList;
	}
	
	

}
