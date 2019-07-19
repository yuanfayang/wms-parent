package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessMaterialsMapper;
import com.deer.wms.produce.manage.model.ProcessMaterials;
import com.deer.wms.produce.manage.model.ProcessMaterialsParams;
import com.deer.wms.produce.manage.service.ProcessMaterialsService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
@Service
@Transactional
public class ProcessMaterialsServiceImpl extends AbstractService<ProcessMaterials, Integer> implements ProcessMaterialsService {

    @Autowired
    private ProcessMaterialsMapper processMaterialsMapper;


    //@Override
    //public List<ProcessMaterials> findList(ProcessMaterialsParams params) {
    //    return processMaterialsMapper.findList(params);
    //}
}
