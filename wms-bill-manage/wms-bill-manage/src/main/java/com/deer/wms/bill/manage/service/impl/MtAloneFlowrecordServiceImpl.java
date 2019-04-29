package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneFlowrecordMapper;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;
import com.deer.wms.bill.manage.model.MtAloneFlowrecordCriteria;
import com.deer.wms.bill.manage.service.MtAloneFlowrecordService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneFlowrecord;

/**
 * Created by  on 2018/12/11.
 */
@Service
@Transactional
public class MtAloneFlowrecordServiceImpl extends AbstractService<MtAloneFlowrecord, Integer> implements MtAloneFlowrecordService {

    @Autowired
    private MtAloneFlowrecordMapper mtAloneFlowrecordMapper;


    @Override
    public List<MtAloneFlowrecord> findList(MtAloneFlowrecordCriteria  criteria) {
        return mtAloneFlowrecordMapper.findList(criteria);
    }
}
