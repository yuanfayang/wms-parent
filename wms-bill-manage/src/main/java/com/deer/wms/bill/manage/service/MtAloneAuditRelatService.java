package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditRelat;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditRelatService extends Service<MtAloneAuditRelat, Integer> {


    List<MtAloneAuditRelat> findList(MtAloneAuditRelatParams  params) ;

    Integer findMaxId();


}
