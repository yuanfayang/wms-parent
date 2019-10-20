package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProcessBomParams;
import com.deer.wms.produce.manage.model.ProcessBomVo;
import com.deer.wms.produce.manage.model.ProcessMaterialsBom;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProcessBomMapper extends Mapper<ProcessBom> {
    List<ProcessBom> findList(ProcessBomParams params);

    List<ProcessBom> findListById(ProcessBomParams params);

    Integer insertProductProcessBom(ProcessBomParams params);

    void insertProcessBom(List<ProcessBomVo> list);

    void insertProcessMaterialsBom(List<ProcessMaterialsBom> list);

    List<ProcessBom> findListByProductBomId(ProcessBomParams params);
}