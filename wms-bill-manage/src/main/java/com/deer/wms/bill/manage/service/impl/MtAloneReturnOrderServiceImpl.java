package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneReturnOrderMapper;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;
import com.deer.wms.bill.manage.service.MtAloneReturnOrderService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;

/**
 * Created by  on 2018/12/11.
 */
@Service
@Transactional
public class MtAloneReturnOrderServiceImpl extends AbstractService<MtAloneReturnOrder, Integer> implements MtAloneReturnOrderService {

    @Autowired
    private MtAloneReturnOrderMapper mtAloneReturnOrderMapper;


    @Override
    public List<MtAloneReturnOrder> findList(MtAloneReturnOrderCriteria  criteria) {
        return mtAloneReturnOrderMapper.findList(criteria);
    }


	@Override
	public List<MtAloneDeliveryOrder> findListBykeyAndDate(MtAloneReturnOrderCriteria criteria) {
		 return mtAloneReturnOrderMapper.findListBykeyAndDate(criteria);
	}


	@Override
	public List<MtAloneProductDet> findDetListByOrder(MtAloneReturnOrderCriteria criteria) {
		return mtAloneReturnOrderMapper.findDetListByOrder(criteria);
	}
}
