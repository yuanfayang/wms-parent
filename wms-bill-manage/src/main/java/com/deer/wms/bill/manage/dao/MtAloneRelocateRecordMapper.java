package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneRelocateRecord;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecordCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneRelocateRecordMapper extends Mapper<MtAloneRelocateRecord> {
    List<MtAloneRelocateRecord> findList(MtAloneRelocateRecordCriteria criteria);
}