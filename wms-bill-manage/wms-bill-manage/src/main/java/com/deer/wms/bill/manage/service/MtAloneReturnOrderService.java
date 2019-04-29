package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneReturnOrder;
import com.deer.wms.bill.manage.model.MtAloneReturnOrderCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneReturnOrder;

/**
 * Created by  on 2018/12/11.
 */
public interface MtAloneReturnOrderService extends Service<MtAloneReturnOrder, Integer> {


    List<MtAloneReturnOrder> findList(MtAloneReturnOrderCriteria  criteria) ;

}
