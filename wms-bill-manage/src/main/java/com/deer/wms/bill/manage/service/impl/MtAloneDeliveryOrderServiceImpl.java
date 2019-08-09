package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneDeliveryOrderMapper;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.MtAloneDeliveryOrderService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;

/**
 * Created by  on 2018/12/08.
 */
@Service
@Transactional
public class MtAloneDeliveryOrderServiceImpl extends AbstractService<MtAloneDeliveryOrder, Integer> implements MtAloneDeliveryOrderService {

    @Autowired
    private MtAloneDeliveryOrderMapper mtAloneDeliveryOrderMapper;


    @Override
    public List<MtAloneDeliveryOrder> findList(MtAloneDeliveryOrderCriteria  criteria) {
        return mtAloneDeliveryOrderMapper.findList(criteria);
    }


	@Override
	public List<MtAloneDeliveryOrder> findListBykeyAndDate(MtAloneDeliveryOrderCriteria criteria) {
		return mtAloneDeliveryOrderMapper.findListBykeyAndDate(criteria);
	}


	@Override
	public List<MtAloneDeliveryOrder> findDeliveryOrderDetList(MtAloneDeliveryOrderCriteria criteria) {
		return mtAloneDeliveryOrderMapper.findDeliveryOrderDetList(criteria);
	}


	@Override
	public List<MtAloneProductDetVO> findDetListByOrder(MtAloneDeliveryOrderParams params) {
		return mtAloneDeliveryOrderMapper.findDetListByOrder(params);
	}


	@Override
	public List<MtAloneDeliveryOrderVO> findListNew(MtAloneDeliveryOrderParams params) {
		return mtAloneDeliveryOrderMapper.findListNew(params);
	}

	@Override
	public List<MtAloneInBoundOrderProVO> findOrderProList(MtAloneDeliveryOrderParams params) {
		return mtAloneDeliveryOrderMapper.findOrderProList(params);
	}

	@Override
	public List<MtAloneDeliveryOrderDetList> findOrderProDetList(MtAloneDeliveryOrderParams params) {
		return mtAloneDeliveryOrderMapper.findOrderProDetList(params);
	}

	@Override
	public MtAloneDeliveryOrder findOrderByAuditTaskId(MtAloneDeliveryOrderParams mtAloneOutboundOrderParams) {
		return mtAloneDeliveryOrderMapper.findOrderByAuditTaskId(mtAloneOutboundOrderParams);
	}

}
