package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MaterialsInfoParams;
import com.deer.wms.produce.manage.model.MaterialsStockInfo;
import com.deer.wms.produce.manage.model.MaterialsStockInfoParams;
import com.deer.wms.project.seed.core.service.Service;

import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
public interface MaterialsStockInfoService extends Service<MaterialsStockInfo, Integer> {


    List<MaterialsStockInfo> findList(MaterialsStockInfoParams params);

    Float getStockQuantityByMaId(MaterialsInfoParams params);

    String getStockPositionByMaId(MaterialsInfoParams params);
}
