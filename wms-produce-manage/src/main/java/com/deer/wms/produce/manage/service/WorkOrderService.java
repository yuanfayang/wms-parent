package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.WorkOrder;

import com.deer.wms.produce.manage.model.WorkOrderParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface WorkOrderService extends Service<WorkOrder, Integer> {


    List<WorkOrder> findList(WorkOrderParams params) ;

}
