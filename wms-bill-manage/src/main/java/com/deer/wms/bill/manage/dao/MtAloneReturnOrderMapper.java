package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneReturnOrderMapper extends Mapper<MtAloneReturnOrder> {

	List<MtAloneReturnOrder> findList(MtAloneReturnOrderCriteria criteria);

	List<MtAloneDeliveryOrder> findListBykeyAndDate(MtAloneReturnOrderCriteria criteria);

	List<MtAloneProductDet> findDetListByOrder(MtAloneReturnOrderCriteria criteria);
}