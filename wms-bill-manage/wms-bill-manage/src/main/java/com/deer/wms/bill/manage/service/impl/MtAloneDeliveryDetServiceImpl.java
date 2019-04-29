package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneDeliveryDetMapper;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneDeliveryDetService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;

/**
 * Created by  on 2019/03/07.
 */
@Service
@Transactional
public class MtAloneDeliveryDetServiceImpl extends AbstractService<MtAloneDeliveryDet, Integer> implements MtAloneDeliveryDetService {

    @Autowired
    private MtAloneDeliveryDetMapper mtAloneDeliveryDetMapper;


    @Override
    public List<MtAloneDeliveryDet> findList(MtAloneDeliveryDetCriteria  criteria) {
        return mtAloneDeliveryDetMapper.findList(criteria);
    }
}
