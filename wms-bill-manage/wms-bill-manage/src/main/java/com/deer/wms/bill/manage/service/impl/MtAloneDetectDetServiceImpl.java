package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneDetectDetMapper;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;
import com.deer.wms.bill.manage.model.MtAloneDetectDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneDetectDetService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDetectDet;

/**
 * Created by  on 2019/03/14.
 */
@Service
@Transactional
public class MtAloneDetectDetServiceImpl extends AbstractService<MtAloneDetectDet, Integer> implements MtAloneDetectDetService {

    @Autowired
    private MtAloneDetectDetMapper mtAloneDetectDetMapper;


    @Override
    public List<MtAloneDetectDet> findList(MtAloneDetectDetCriteria  criteria) {
        return mtAloneDetectDetMapper.findList(criteria);
    }
}
