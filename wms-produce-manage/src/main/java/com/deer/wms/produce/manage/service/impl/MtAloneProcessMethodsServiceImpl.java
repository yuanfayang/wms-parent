package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProcessMethodsMapper;
import com.deer.wms.produce.manage.model.MtAloneProcessMethods;
import com.deer.wms.produce.manage.model.MtAloneProcessMethodsParams;
import com.deer.wms.produce.manage.service.MtAloneProcessMethodsService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/10/16.
 */
@Service
@Transactional
public class MtAloneProcessMethodsServiceImpl extends AbstractService<MtAloneProcessMethods, Integer> implements MtAloneProcessMethodsService {

    @Autowired
    private MtAloneProcessMethodsMapper mtAloneProcessMethodsMapper;


    @Override
    public List<MtAloneProcessMethods> findList(MtAloneProcessMethodsParams  params) {
        return mtAloneProcessMethodsMapper.findList(params);
    }
}
