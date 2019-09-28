package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProcessBomParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProcessBomMapper extends Mapper<ProcessBom> {
    List<ProcessBom> findList(ProcessBomParams params);

    List<ProcessBom> findListById(ProcessBomParams params);
}