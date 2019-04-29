package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetVO;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryParams;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDeliveryVO;
import com.deer.wms.bill.manage.model.MtAloneProductDetParams;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneDeliveryDetMapper extends Mapper<MtAloneDeliveryDet> {

	List<MtAloneDeliveryDet> findList(MtAloneDeliveryDetCriteria criteria);

	void delDetByDeliveryOrder(MtAloneDeliveryDetParams params);

	Integer findDeliveryDetCountByCode(MtAloneDeliveryDetParams mtAloneDeliveryDetParams);

	List<MtAloneDeliveryDet> findDeliveryDetsByCode(MtAloneDeliveryDetParams params);

	List<MtAloneDeliveryDetVO> findListNew(MtAloneProductDetParams params);

	List<MtAloneDeliveryOrder> findDeliveryOrderDetList(MtAloneDeliveryDetParams params);

	List<MtAloneProductDetVO> finddeliveryDetsByOrder(MtAloneDeliveryOrderParams params);

	List<MtAloneProductDeliveryVO> findDeliveryDetForms(MtAloneDeliveryParams params);
}