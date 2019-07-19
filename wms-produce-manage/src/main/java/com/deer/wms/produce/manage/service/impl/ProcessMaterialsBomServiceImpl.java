package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessMaterialsBomMapper;
import com.deer.wms.produce.manage.model.ProcessMaterialsBom;
import com.deer.wms.produce.manage.model.ProcessMaterialsBomParams;
import com.deer.wms.produce.manage.service.ProcessMaterialsBomService;
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
public class ProcessMaterialsBomServiceImpl extends AbstractService<ProcessMaterialsBom, Integer> implements ProcessMaterialsBomService {

    @Autowired
    private ProcessMaterialsBomMapper processMaterialsBomMapper;


    //@Override
    //public List<ProcessMaterialsBom> findList(ProcessMaterialsBomParams params) {
    //    return processMaterialsBomMapper.findList(params);
    //}
}
