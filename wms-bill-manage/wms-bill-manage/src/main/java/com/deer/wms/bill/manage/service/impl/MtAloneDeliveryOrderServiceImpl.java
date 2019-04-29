package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneDeliveryOrderMapper;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.service.MtAloneDeliveryOrderService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;

/**
 * Created by  on 2019/03/05.
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
}
