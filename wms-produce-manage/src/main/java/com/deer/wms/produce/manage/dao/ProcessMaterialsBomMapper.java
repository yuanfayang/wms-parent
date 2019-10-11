package com.deer.wms.produce.manage.dao;


import com.deer.wms.produce.manage.model.ProcessMaterialsBom;
import com.deer.wms.produce.manage.model.ProcessMaterialsBomParams;
import com.deer.wms.produce.manage.model.ProcessMaterialsBomVo;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProcessMaterialsBomMapper extends Mapper<ProcessMaterialsBom> {

    List<ProcessMaterialsBomVo> findProcMatBomVoListByProId(ProcessMaterialsBomParams params);
}