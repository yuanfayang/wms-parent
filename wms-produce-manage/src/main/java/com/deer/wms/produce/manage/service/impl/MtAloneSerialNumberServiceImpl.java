package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneSerialNumberMapper;
import com.deer.wms.produce.manage.model.MtAloneSerialNumber;
import com.deer.wms.produce.manage.model.MtAloneSerialNumberParams;
import com.deer.wms.produce.manage.service.MtAloneSerialNumberService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/10/17.
 */
@Service
@Transactional
public class MtAloneSerialNumberServiceImpl extends AbstractService<MtAloneSerialNumber, Integer> implements MtAloneSerialNumberService {

    @Autowired
    private MtAloneSerialNumberMapper mtAloneSerialNumberMapper;


    @Override
    public List<MtAloneSerialNumber> findList(MtAloneSerialNumberParams  params) {
        return mtAloneSerialNumberMapper.findList(params);
    }

    @Override
    public void updatePinCounter(MtAloneSerialNumber mtAloneSerialNumber) {
        mtAloneSerialNumberMapper.updatePinCounter(mtAloneSerialNumber);
    }
}
