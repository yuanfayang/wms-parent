package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;

/**
 * Created by  on 2019/03/05.
 */
public interface MtAloneDeliveryOrderService extends Service<MtAloneDeliveryOrder, Integer> {


    List<MtAloneDeliveryOrder> findList(MtAloneDeliveryOrderCriteria  criteria) ;

}
