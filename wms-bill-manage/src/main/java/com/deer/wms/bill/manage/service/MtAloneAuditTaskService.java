package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditTask;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditTaskService extends Service<MtAloneAuditTask, Integer> {


    List<MtAloneAuditTask> findList(MtAloneAuditTaskParams  params) ;

}
