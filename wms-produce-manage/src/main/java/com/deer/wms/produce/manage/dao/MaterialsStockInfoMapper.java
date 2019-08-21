package com.deer.wms.produce.manage.dao;


import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.produce.manage.model.MaterialsStockInfo;
import com.deer.wms.produce.manage.model.MaterialsStockInfoParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MaterialsStockInfoMapper extends Mapper<MaterialsStockInfo> {
    List<MaterialsStockInfo> findList(MaterialsStockInfoParams params);

    Float getStockQuantityByMaId(MaterialsInfoParams params);

    String getStockPositionByMaId(MaterialsInfoParams params);
}