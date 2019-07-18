package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditRelatMbMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMb;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatMbParams;
import com.deer.wms.bill.manage.service.MtAloneAuditRelatMbService;

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
public class MtAloneAuditRelatMbServiceImpl extends AbstractService<MtAloneAuditRelatMb, Integer> implements MtAloneAuditRelatMbService {

    @Autowired
    private MtAloneAuditRelatMbMapper mtAloneAuditRelatMbMapper;


    @Override
    public List<MtAloneAuditRelatMb> findList(MtAloneAuditRelatMbParams  params) {
        return mtAloneAuditRelatMbMapper.findList(params);
    }
}
