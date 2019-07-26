package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditRelat;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditRelatMapper extends Mapper<MtAloneAuditRelat> {
    List<MtAloneAuditRelat> findList(MtAloneAuditRelatParams params);
    Integer findMaxId();
}