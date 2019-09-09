package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.WorkOrderMapper;
import com.deer.wms.produce.manage.model.WorkOrder;
import com.deer.wms.produce.manage.model.WorkOrderParams;
import com.deer.wms.produce.manage.service.WorkOrderService;

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
public class WorkOrderServiceImpl extends AbstractService<WorkOrder, Integer> implements WorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;


    @Override
    public List<WorkOrder> findList(WorkOrderParams params) {
        return workOrderMapper.findList(params);
    }
}
