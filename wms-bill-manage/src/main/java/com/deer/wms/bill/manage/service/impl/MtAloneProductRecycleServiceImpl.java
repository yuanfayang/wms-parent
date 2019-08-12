package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneProductRecycleMapper;
import com.deer.wms.bill.manage.model.MtAloneProductRecycle;
import com.deer.wms.bill.manage.model.MtAloneProductRecycleParams;
import com.deer.wms.bill.manage.service.MtAloneProductRecycleService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/08/12.
 */
@Service
@Transactional
public class MtAloneProductRecycleServiceImpl extends AbstractService<MtAloneProductRecycle, Integer> implements MtAloneProductRecycleService {

    @Autowired
    private MtAloneProductRecycleMapper mtAloneProductRecycleMapper;


    @Override
    public List<MtAloneProductRecycle> findList(MtAloneProductRecycleParams  params) {
        return mtAloneProductRecycleMapper.findList(params);
    }
}
