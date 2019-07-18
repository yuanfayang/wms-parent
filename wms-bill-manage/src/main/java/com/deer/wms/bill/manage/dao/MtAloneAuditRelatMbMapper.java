package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditRelatMb;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMbParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditRelatMbMapper extends Mapper<MtAloneAuditRelatMb> {
    List<MtAloneAuditRelatMb> findList(MtAloneAuditRelatMbParams params);
}