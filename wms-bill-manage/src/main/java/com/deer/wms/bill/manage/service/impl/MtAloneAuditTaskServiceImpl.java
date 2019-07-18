package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditTaskMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditTask;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskParams;
import com.deer.wms.bill.manage.service.MtAloneAuditTaskService;

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
public class MtAloneAuditTaskServiceImpl extends AbstractService<MtAloneAuditTask, Integer> implements MtAloneAuditTaskService {

    @Autowired
    private MtAloneAuditTaskMapper mtAloneAuditTaskMapper;


    @Override
    public List<MtAloneAuditTask> findList(MtAloneAuditTaskParams  params) {
        return mtAloneAuditTaskMapper.findList(params);
    }
}
