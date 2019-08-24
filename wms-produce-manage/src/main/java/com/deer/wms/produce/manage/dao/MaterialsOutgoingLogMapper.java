package com.deer.wms.produce.manage.dao;


import com.deer.wms.message.model.Consult;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLog;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogParams;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogVO;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MaterialsOutgoingLogMapper extends Mapper<MaterialsOutgoingLog> {
    List<MaterialsOutgoingLogVO> findListByOneMaterial(MaterialsOutgoingLogParams params);

}