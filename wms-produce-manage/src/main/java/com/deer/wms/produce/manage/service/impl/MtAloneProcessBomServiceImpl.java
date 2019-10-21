package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProcessBomMapper;
import com.deer.wms.produce.manage.model.MtAloneProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProcessBomParams;
import com.deer.wms.produce.manage.service.MtAloneProcessBomService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/10/08.
 */
@Service
@Transactional
public class MtAloneProcessBomServiceImpl extends AbstractService<MtAloneProcessBom, Integer> implements MtAloneProcessBomService {

    @Autowired
    private MtAloneProcessBomMapper mtAloneProcessBomMapper;


    @Override
    public List<MtAloneProcessBom> findList(MtAloneProcessBomParams  params) {
        //return mtAloneProcessBomMapper.findList(params);
        return null;
    }
}
