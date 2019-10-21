package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProcessMaterialsBomMapper;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBom;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomParams;
import com.deer.wms.produce.manage.service.MtAloneProcessMaterialsBomService;

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
public class MtAloneProcessMaterialsBomServiceImpl extends AbstractService<MtAloneProcessMaterialsBom, Integer> implements MtAloneProcessMaterialsBomService {

    @Autowired
    private MtAloneProcessMaterialsBomMapper mtAloneProcessMaterialsBomMapper;


    @Override
    public List<MtAloneProcessMaterialsBom> findList(MtAloneProcessMaterialsBomParams  params) {
        //return mtAloneProcessMaterialsBomMapper.findList(params);
        return null;
    }
}
