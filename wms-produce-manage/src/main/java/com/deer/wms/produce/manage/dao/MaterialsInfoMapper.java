package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoDto;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MaterialsInfoMapper extends Mapper<MaterialsInfo> {
    List<MaterialsInfoDto> findList(MaterialsInfoParams params);
}