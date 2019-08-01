package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneAuditNodeOpinionTabMapper;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTab;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabParams;
import com.deer.wms.bill.manage.model.MtAloneAuditNodeOpinionTabVo;
import com.deer.wms.bill.manage.service.MtAloneAuditNodeOpinionTabService;

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
public class MtAloneAuditNodeOpinionTabServiceImpl extends AbstractService<MtAloneAuditNodeOpinionTab, Integer> implements MtAloneAuditNodeOpinionTabService {

    @Autowired
    private MtAloneAuditNodeOpinionTabMapper mtAloneAuditNodeOpinionTabMapper;


    @Override
    public List<MtAloneAuditNodeOpinionTabVo> findList(MtAloneAuditNodeOpinionTabParams  params) {
        return mtAloneAuditNodeOpinionTabMapper.findList(params);
    }
}
