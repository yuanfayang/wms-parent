package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneInBoundOrderProVO;
import com.deer.wms.bill.manage.model.MtAloneInboundOrder;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderParams;

import com.deer.wms.bill.manage.model.MtAloneInboundOrderProDetVO;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneInboundOrderService extends Service<MtAloneInboundOrder, Integer> {


    List<MtAloneInboundOrder> findList(MtAloneInboundOrderParams  params) ;

    List<MtAloneInBoundOrderProVO> findOrderProList(MtAloneInboundOrderParams params);

    List<MtAloneInboundOrderProDetVO> findOrderProDetList(MtAloneInboundOrderParams params);

    MtAloneInBoundOrderProVO findOrderByAuditTaskId(MtAloneInboundOrderParams params);

    MtAloneInBoundOrderProVO findProListByOrderCode(MtAloneInboundOrderParams params);
}
