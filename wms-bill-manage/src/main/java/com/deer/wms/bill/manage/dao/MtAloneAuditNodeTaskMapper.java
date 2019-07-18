package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditNodeTask;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeTaskParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneAuditNodeTaskMapper extends Mapper<MtAloneAuditNodeTask> {
    List<MtAloneAuditNodeTask> findList(MtAloneAuditNodeTaskParams params);
}