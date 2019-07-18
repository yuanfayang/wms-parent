package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditNodeTaskService extends Service<MtAloneAuditNodeTask, Integer> {


    List<MtAloneAuditNodeTask> findList(MtAloneAuditNodeTaskParams  params) ;

}
