package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditTaskMb;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskMbParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import java.util.List;

public interface MtAloneAuditTaskMbMapper extends Mapper<MtAloneAuditTaskMb> {
    List<MtAloneAuditTaskMb> findList(MtAloneAuditTaskMbParams params);
}