package com.deer.wms.bill.manage.dao;

import java.util.List;

import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneFlowrecordMapper extends Mapper<MtAloneFlowrecord> {

	List<MtAloneFlowrecord> findList(MtAloneFlowrecordCriteria criteria);

	List<MtAloneFlowrecordCriteria> findListByOrder(MtAloneFlowrecordCriteria criteria);

	void deleteByDeliveryOrderCode(MtAloneFlowrecordCriteria criteria);

	void deleteByReturnOrderCode(MtAloneFlowrecordCriteria criteria);

	List<MtAloneFlowrecordCriteria> flowListByProductName(MtAloneFlowrecordCriteria criteria);
}