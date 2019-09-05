package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MaterialsInfo;
import com.deer.wms.produce.manage.model.MaterialsInfoDto;
import com.deer.wms.produce.manage.model.MaterialsInfoParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
public interface MaterialsInfoService extends Service<MaterialsInfo, Integer> {
    List<MaterialsInfoDto> findList(MaterialsInfoParams params);

    MaterialsInfoDto findDetailById(MaterialsInfoParams params);
}
