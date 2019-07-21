package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessDetectRelatMapper;
import com.deer.wms.produce.manage.model.ProcessDetectRelat;
import com.deer.wms.produce.manage.model.ProcessDetectRelatParams;
import com.deer.wms.produce.manage.service.ProcessDetectRelatService;
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
public class ProcessDetectRelatServiceImpl extends AbstractService<ProcessDetectRelat, Integer> implements ProcessDetectRelatService {

    @Autowired
    private ProcessDetectRelatMapper processDetectRelatMapper;


    @Override
    public List<ProcessDetectRelat> findList(ProcessDetectRelatParams params) {
       return processDetectRelatMapper.findList(params);
    }
}
