package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditTask;
import com.deer.wms.bill.manage.model.MtAloneAuditTaskParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditTaskMapper extends Mapper<MtAloneAuditTask> {
    List<MtAloneAuditTask> findList(MtAloneAuditTaskParams params);
}