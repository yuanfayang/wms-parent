package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditClass;
import com.deer.wms.bill.manage.model.MtAloneAuditClassParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditClassService extends Service<MtAloneAuditClass, Integer> {


    List<MtAloneAuditClass> findList(MtAloneAuditClassParams  params) ;

}
