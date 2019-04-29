package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneRelocateRecordMapper;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecord;
import com.deer.wms.bill.manage.model.MtAloneRelocateRecordCriteria;
import com.deer.wms.bill.manage.service.MtAloneRelocateRecordService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by mt on 2018/12/30.
 */
@Service
@Transactional
public class MtAloneRelocateRecordServiceImpl extends AbstractService<MtAloneRelocateRecord, Integer> implements MtAloneRelocateRecordService {

    @Autowired
    private MtAloneRelocateRecordMapper mtAloneRelocateRecordMapper;


    @Override
    public List<MtAloneRelocateRecord> findList(MtAloneRelocateRecordCriteria  criteria) {
        return mtAloneRelocateRecordMapper.findList(criteria);
    }
}
