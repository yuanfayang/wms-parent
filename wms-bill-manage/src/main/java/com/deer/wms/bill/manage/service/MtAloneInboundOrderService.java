package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneInboundOrder;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneInboundOrderService extends Service<MtAloneInboundOrder, Integer> {


    List<MtAloneInboundOrder> findList(MtAloneInboundOrderParams  params) ;

}
