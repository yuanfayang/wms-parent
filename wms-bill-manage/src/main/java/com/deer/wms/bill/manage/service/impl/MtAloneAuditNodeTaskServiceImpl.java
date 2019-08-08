package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditNodeTaskMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeTaskService;

import com.deer.wms.intercept.common.data.CurrentUser;
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

    @Override
    public List<MtAloneAuditNodeTask> findBacklogByUserId(CurrentUser currentUser) {
        return mtAloneAuditNodeTaskMapper.findBacklogByUserId(currentUser);
    }

    @Override
    public MtAloneAuditNodeTask findByTaskIdAndCurrentId(MtAloneAuditNodeTaskParams params) {
        return mtAloneAuditNodeTaskMapper.findByTaskIdAndCurrentId(params);
    }

    @Override
    public void updateTem(MtAloneAuditNodeTask model) {
        mtAloneAuditNodeTaskMapper.updateTem(model);
    }

    @Override
    public Integer findBacklogNumByUserId(CurrentUser currentUser) {
        return mtAloneAuditNodeTaskMapper.findBacklogNumByUserId(currentUser);
    }

    @Override
    public void updateOrder(MtAloneAuditNodeTaskParams params) {
        mtAloneAuditNodeTaskMapper.updateOrder(params);
    }

    @Override
    public List<MtAloneAuditNodeTask> listByAuditTaskId(Integer auditTaskId) {
        return mtAloneAuditNodeTaskMapper.listByAuditTaskId(auditTaskId);
    }
}
