package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTab;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditNodeOpinionTabMapper extends Mapper<MtAloneAuditNodeOpinionTab> {
    List<MtAloneAuditNodeOpinionTab> findList(MtAloneAuditNodeOpinionTabParams params);
}