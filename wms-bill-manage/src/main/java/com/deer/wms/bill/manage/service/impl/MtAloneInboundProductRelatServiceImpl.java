package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneInboundProductRelatMapper;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelat;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelatParams;
import com.deer.wms.bill.manage.service.MtAloneInboundProductRelatService;

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
public class MtAloneInboundProductRelatServiceImpl extends AbstractService<MtAloneInboundProductRelat, Integer> implements MtAloneInboundProductRelatService {

    @Autowired
    private MtAloneInboundProductRelatMapper mtAloneInboundProductRelatMapper;


    @Override
    public List<MtAloneInboundProductRelat> findList(MtAloneInboundProductRelatParams  params) {
        return mtAloneInboundProductRelatMapper.findList(params);
    }
}
