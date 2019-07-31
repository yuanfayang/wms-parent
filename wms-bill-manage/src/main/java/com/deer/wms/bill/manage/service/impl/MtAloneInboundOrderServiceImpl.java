package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneInboundOrderMapper;
import com.deer.wms.bill.manage.model.MtAloneInBoundOrderProVO;
import com.deer.wms.bill.manage.model.MtAloneInboundOrder;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderParams;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderProDetVO;
import com.deer.wms.bill.manage.service.MtAloneInboundOrderService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
@Service
@Transactional
public class MtAloneInboundOrderServiceImpl extends AbstractService<MtAloneInboundOrder, Integer> implements MtAloneInboundOrderService {

    @Autowired
    private MtAloneInboundOrderMapper mtAloneInboundOrderMapper;


    @Override
    public List<MtAloneInboundOrder> findList(MtAloneInboundOrderParams  params) {
        return mtAloneInboundOrderMapper.findList(params);
    }

    @Override
    public List<MtAloneInBoundOrderProVO> findOrderProList(MtAloneInboundOrderParams params) {
        return mtAloneInboundOrderMapper.findOrderProList(params);
    }

    @Override
    public List<MtAloneInboundOrderProDetVO> findOrderProDetList(MtAloneInboundOrderParams params) {
        return mtAloneInboundOrderMapper.findOrderProDetList(params);
    }

    @Override
    public MtAloneInBoundOrderProVO  findOrderByAuditTaskId(MtAloneInboundOrderParams params) {
        return mtAloneInboundOrderMapper.findOrderByAuditTaskId(params);
    }

    @Override
    public MtAloneInBoundOrderProVO findProListByOrderCode(MtAloneInboundOrderParams params) {
        return mtAloneInboundOrderMapper.findProListByOrderCode(params);
    }

    @Override
    public MtAloneInboundOrderProDetVO findOrderProDetByAuditTaskId(MtAloneInboundOrderParams params) {
        return mtAloneInboundOrderMapper.findOrderProDetByAuditTaskId(params);
    }
}
