package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessBomMapper;
import com.deer.wms.produce.manage.model.ProcessBom;
import com.deer.wms.produce.manage.model.ProcessBomParams;
import com.deer.wms.produce.manage.service.ProcessBomService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
@Service
@Transactional
public class ProcessBomServiceImpl extends AbstractService<ProcessBom, Integer> implements ProcessBomService {

    @Autowired
    private ProcessBomMapper processBomMapper;


    @Override
    public List<ProcessBom> findList(ProcessBomParams params) {
        return processBomMapper.findList(params);
    }
}
