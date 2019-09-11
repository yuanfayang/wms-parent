package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProcessBatchRelat;
import com.deer.wms.produce.manage.model.ProcessBatchRelatParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProcessBatchRelatMapper extends Mapper<ProcessBatchRelat> {
    List<ProcessBatchRelat> findList(ProcessBatchRelatParams params);
}