package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProductNameMapper;
import com.deer.wms.produce.manage.model.MtAloneProductName;
import com.deer.wms.produce.manage.model.MtAloneProductNameParams;
import com.deer.wms.produce.manage.service.MtAloneProductNameService;

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
public class MtAloneProductNameServiceImpl extends AbstractService<MtAloneProductName, Integer> implements MtAloneProductNameService {

    @Autowired
    private MtAloneProductNameMapper mtAloneProductNameMapper;


    @Override
    public List<MtAloneProductName> findList(MtAloneProductNameParams  params) {
        return mtAloneProductNameMapper.findList(params);
    }
}
