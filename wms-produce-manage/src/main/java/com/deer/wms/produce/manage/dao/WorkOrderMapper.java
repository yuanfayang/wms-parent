package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.WorkOrder;
import com.deer.wms.produce.manage.model.WorkOrderParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface WorkOrderMapper extends Mapper<WorkOrder> {
    List<WorkOrder> findList(WorkOrderParams params);
}