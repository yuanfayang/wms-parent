package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneProcessMethods;
import com.deer.wms.produce.manage.model.MtAloneProcessMethodsParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneProcessMethodsMapper extends Mapper<MtAloneProcessMethods> {
    List<MtAloneProcessMethods> findList(MtAloneProcessMethodsParams params);
}