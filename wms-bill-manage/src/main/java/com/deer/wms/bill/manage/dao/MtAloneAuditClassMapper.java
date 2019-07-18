package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneAuditClass;
import com.deer.wms.bill.manage.model.MtAloneAuditClassParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import java.util.List;

public interface MtAloneAuditClassMapper extends Mapper<MtAloneAuditClass> {
    List<MtAloneAuditClass> findList(MtAloneAuditClassParams params);
}