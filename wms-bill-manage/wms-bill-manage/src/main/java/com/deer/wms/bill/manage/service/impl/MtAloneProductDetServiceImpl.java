package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneProductDetMapper;
import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;
import com.deer.wms.bill.manage.service.MtAloneProductDetService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProductDet;

/**
 * Created by  on 2019/03/02.
 */
@Service
@Transactional
public class MtAloneProductDetServiceImpl extends AbstractService<MtAloneProductDet, Integer> implements MtAloneProductDetService {

    @Autowired
    private MtAloneProductDetMapper mtAloneProductDetMapper;


    @Override
    public List<MtAloneProductDet> findList(MtAloneProductDetCriteria  criteria) {
        return mtAloneProductDetMapper.findList(criteria);
    }
}
