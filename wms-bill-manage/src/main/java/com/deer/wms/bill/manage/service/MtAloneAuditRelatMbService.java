package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditRelatMb;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMbParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditRelatMbService extends Service<MtAloneAuditRelatMb, Integer> {


    List<MtAloneAuditRelatMb> findList(MtAloneAuditRelatMbParams  params) ;

}
