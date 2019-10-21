package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneMaterialsInfo;
import com.deer.wms.produce.manage.model.MtAloneMaterialsInfoParams;

import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomVO;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/09.
 */
public interface MtAloneMaterialsInfoService extends Service<MtAloneMaterialsInfo, Integer> {

    List<MtAloneProcessMaterialsBomVO> findMaterialByNameAndNum(MtAloneMaterialsInfoParams params);

    List<MtAloneMaterialsInfo> findList(MtAloneMaterialsInfoParams  params) ;

}
