package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditTaskMb;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskMbParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditTaskMbService extends Service<MtAloneAuditTaskMb, Integer> {


    List<MtAloneAuditTaskMb> findList(MtAloneAuditTaskMbParams  params) ;

}
