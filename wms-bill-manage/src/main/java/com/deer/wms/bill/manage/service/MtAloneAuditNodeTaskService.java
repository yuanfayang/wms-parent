package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskRead;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditNodeTaskService extends Service<MtAloneAuditNodeTask, Integer> {


    List<MtAloneAuditNodeTask> findList(MtAloneAuditNodeTaskParams  params) ;

    List<MtAloneAuditNodeTask> findBacklogByUserId(CurrentUser currentUser);

    MtAloneAuditNodeTask findByTaskIdAndCurrentId(MtAloneAuditNodeTaskParams  params);

    void updateTem(MtAloneAuditNodeTask model);

    Integer findBacklogNumByUserId(CurrentUser currentUser);

    void updateOrder(MtAloneAuditNodeTaskParams params);

    List<MtAloneAuditNodeTask> listByAuditTaskId(Integer auditTaskId);

    List<MtAloneAuditNodeTaskRead> findTasksReadByUserId(CurrentUser currentUser);
}
