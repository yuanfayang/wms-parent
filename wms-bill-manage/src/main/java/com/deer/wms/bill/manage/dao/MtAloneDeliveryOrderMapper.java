package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.*;
import com.deer.wms.project.seed.core.mapper.Mapper;


public interface MtAloneDeliveryOrderMapper extends Mapper<MtAloneDeliveryOrder> {

	List<MtAloneDeliveryOrder> findList(MtAloneDeliveryOrderCriteria criteria);

	List<MtAloneDeliveryOrder> findListBykeyAndDate(MtAloneDeliveryOrderCriteria criteria);

	List<MtAloneDeliveryOrder> findDeliveryOrderDetList(MtAloneDeliveryOrderCriteria criteria);

	List<MtAloneProductDetVO> findDetListByOrder(MtAloneDeliveryOrderParams params);

	List<MtAloneDeliveryOrderVO> findListNew(MtAloneDeliveryOrderParams params);

    List<MtAloneInBoundOrderProVO> findOrderProList(MtAloneDeliveryOrderParams params);

	List<MtAloneDeliveryOrderDetList> findOrderProDetList(MtAloneDeliveryOrderParams params);
}