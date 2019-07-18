package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditRelatMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditRelat;
import com.deer.wms.bill.manage.model.MtAloneAuditRelatParams;
import com.deer.wms.bill.manage.service.MtAloneAuditRelatService;

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
public class MtAloneAuditRelatServiceImpl extends AbstractService<MtAloneAuditRelat, Integer> implements MtAloneAuditRelatService {

    @Autowired
    private MtAloneAuditRelatMapper mtAloneAuditRelatMapper;


    @Override
    public List<MtAloneAuditRelat> findList(MtAloneAuditRelatParams  params) {
        return mtAloneAuditRelatMapper.findList(params);
    }
}
