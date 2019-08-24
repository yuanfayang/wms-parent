package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoDTO;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface MaterialsInfoMapper extends Mapper<MaterialsInfo> {
    List<MaterialsInfoDTO> findList(MaterialsInfoParams params);

    MaterialsInfoDTO findDetailById(MaterialsInfoParams params);
}