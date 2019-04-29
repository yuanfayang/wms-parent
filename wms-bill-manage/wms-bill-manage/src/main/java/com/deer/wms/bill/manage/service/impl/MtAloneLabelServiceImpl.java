package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneLabelMapper;
import com.deer.wms.bill.manage.model.MtAloneLabel;
import com.deer.wms.bill.manage.model.MtAloneLabelCriteria;
import com.deer.wms.bill.manage.service.MtAloneLabelService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneLabel;

/**
 * Created by  on 2018/12/25.
 */
@Service
@Transactional
public class MtAloneLabelServiceImpl extends AbstractService<MtAloneLabel, Integer> implements MtAloneLabelService {

    @Autowired
    private MtAloneLabelMapper mtAloneLabelMapper;


    @Override
    public List<MtAloneLabel> findList(MtAloneLabelCriteria  criteria) {
        return mtAloneLabelMapper.findList(criteria);
    }
}
