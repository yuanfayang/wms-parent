package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;

/**
 * Created by  on 2018/12/10.
 */
public interface MtAloneFlowrecordService extends Service<MtAloneFlowrecord, Integer> {


    List<MtAloneFlowrecord> findList(MtAloneFlowrecordCriteria  criteria) ;

	List<MtAloneFlowrecordCriteria> findListByOrder(MtAloneFlowrecordCriteria criteria);

	void deleteByDeliveryOrderCode(MtAloneFlowrecordCriteria criteria);

	void deleteByReturnOrderCode(MtAloneFlowrecordCriteria criteria);

	List<MtAloneFlowrecordCriteria> flowListByProductName(MtAloneFlowrecordCriteria criteria);

}
