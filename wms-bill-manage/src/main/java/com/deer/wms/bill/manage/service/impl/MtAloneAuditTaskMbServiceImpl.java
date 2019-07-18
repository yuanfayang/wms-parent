package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditTaskMbMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskMb;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskMbParams;
import com.deer.wms.bill.manage.service.MtAloneAuditTaskMbService;

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
public class MtAloneAuditTaskMbServiceImpl extends AbstractService<MtAloneAuditTaskMb, Integer> implements MtAloneAuditTaskMbService {

    @Autowired
    private MtAloneAuditTaskMbMapper mtAloneAuditTaskMbMapper;


    @Override
    public List<MtAloneAuditTaskMb> findList(MtAloneAuditTaskMbParams  params) {
        return mtAloneAuditTaskMbMapper.findList(params);
    }
}
