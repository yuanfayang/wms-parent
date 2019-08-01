package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTab;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabParams;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabVo;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneAuditNodeOpinionTabService extends Service<MtAloneAuditNodeOpinionTab, Integer> {


    List<MtAloneAuditNodeOpinionTabVo> findList(MtAloneAuditNodeOpinionTabParams  params) ;

}
