package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneMaterialsInfo;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfoParams;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomVO;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneMaterialsInfoMapper extends Mapper<MtAloneMaterialsInfo> {
    List<MtAloneProcessMaterialsBomVO> findMaterialByNameOrNum(MtAloneMaterialsInfoParams params);
}