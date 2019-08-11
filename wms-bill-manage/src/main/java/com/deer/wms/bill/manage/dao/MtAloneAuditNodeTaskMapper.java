package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskRead;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditNodeTaskMapper extends Mapper<MtAloneAuditNodeTask> {
    List<MtAloneAuditNodeTask> findList(MtAloneAuditNodeTaskParams params);

    List<MtAloneAuditNodeTask> findBacklogByUserId(CurrentUser currentUser);

    MtAloneAuditNodeTask findByTaskIdAndCurrentId(MtAloneAuditNodeTaskParams params);

    void updateTem(MtAloneAuditNodeTask model);

    Integer findBacklogNumByUserId(CurrentUser currentUser);

    void updateOrder(MtAloneAuditNodeTaskParams params);

    List<MtAloneAuditNodeTask> listByAuditTaskId(Integer auditTaskId);

    List<MtAloneAuditNodeTaskRead> findTasksReadByUserId(CurrentUser currentUser);

    Integer findNotReadNumByUserId(CurrentUser currentUser);
}