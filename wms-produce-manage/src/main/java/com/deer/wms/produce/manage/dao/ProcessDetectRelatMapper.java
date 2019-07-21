package com.deer.wms.produce.manage.dao;


import com.deer.wms.produce.manage.model.ProcessDetectRelat;
import com.deer.wms.produce.manage.model.ProcessDetectRelatParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProcessDetectRelatMapper extends Mapper<ProcessDetectRelat> {
    List<ProcessDetectRelat> findList(ProcessDetectRelatParams params);
}