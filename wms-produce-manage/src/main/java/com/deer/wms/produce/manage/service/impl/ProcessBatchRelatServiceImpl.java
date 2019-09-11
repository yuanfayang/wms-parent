package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProcessBatchRelatMapper;
import com.deer.wms.produce.manage.model.ProcessBatchRelat;
import com.deer.wms.produce.manage.model.ProcessBatchRelatParams;
import com.deer.wms.produce.manage.service.ProcessBatchRelatService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
@Service
@Transactional
public class ProcessBatchRelatServiceImpl extends AbstractService<ProcessBatchRelat, Integer> implements ProcessBatchRelatService {

    @Autowired
    private ProcessBatchRelatMapper processBatchRelatMapper;


    @Override
    public List<ProcessBatchRelat> findList(ProcessBatchRelatParams params) {
        return processBatchRelatMapper.findList(params);
    }
}
