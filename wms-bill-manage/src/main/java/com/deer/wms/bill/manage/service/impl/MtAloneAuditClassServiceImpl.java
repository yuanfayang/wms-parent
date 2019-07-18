package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditClassMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditClass;
import com.deer.wms.bill.manage.model.MtAloneAuditClassParams;
import com.deer.wms.bill.manage.service.MtAloneAuditClassService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
@Service
@Transactional
public class MtAloneAuditClassServiceImpl extends AbstractService<MtAloneAuditClass, Integer> implements MtAloneAuditClassService {

    @Autowired
    private MtAloneAuditClassMapper mtAloneAuditClassMapper;


    @Override
    public List<MtAloneAuditClass> findList(MtAloneAuditClassParams  params) {
        return mtAloneAuditClassMapper.findList(params);
    }
}
