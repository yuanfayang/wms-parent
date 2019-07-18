package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditNodeTaskMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeTaskService;

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
public class MtAloneAuditNodeTaskServiceImpl extends AbstractService<MtAloneAuditNodeTask, Integer> implements MtAloneAuditNodeTaskService {

    @Autowired
    private MtAloneAuditNodeTaskMapper mtAloneAuditNodeTaskMapper;


    @Override
    public List<MtAloneAuditNodeTask> findList(MtAloneAuditNodeTaskParams  params) {
        return mtAloneAuditNodeTaskMapper.findList(params);
    }
}
