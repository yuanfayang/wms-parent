package com.deer.wms.produce.manage.service;

import com.deer.wms.intercept.common.data.CurrentUser;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLog;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogDto;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogParams;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogVo;
import com.deer.wms.project.seed.core.service.Service;


import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
public interface MaterialsOutgoingLogService extends Service<MaterialsOutgoingLog, Integer> {


    List<MaterialsOutgoingLogVo> findListByOneMaterial(MaterialsOutgoingLogParams params) ;

    void save(MaterialsOutgoingLogDto materialsOutgoingLogDto, CurrentUser currentUser);
}
