package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MaterialsOutgoingLogMapper;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLog;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogParams;
import com.deer.wms.produce.manage.model.MaterialsOutgoingLogVO;
import com.deer.wms.produce.manage.service.MaterialsOutgoingLogService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
@Service
@Transactional
public class MaterialsOutgoingLogServiceImpl extends AbstractService<MaterialsOutgoingLog, Integer> implements MaterialsOutgoingLogService {

    @Autowired
    private MaterialsOutgoingLogMapper materialsOutgoingLogMapper;


    @Override
    public List<MaterialsOutgoingLogVO> findListByOneMaterial(MaterialsOutgoingLogParams params) {
        return materialsOutgoingLogMapper.findListByOneMaterial(params);
    }
}
