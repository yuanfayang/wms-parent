package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoDTO;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
public interface MaterialsInfoService extends Service<MaterialsInfo, Integer> {
    List<MaterialsInfoDTO> findList(MaterialsInfoParams params);

    MaterialsInfoDTO findDetailById(MaterialsInfoParams params);
}
