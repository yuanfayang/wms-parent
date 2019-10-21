package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtStockProvendorMapper;
import com.deer.wms.produce.manage.model.MtStockProvendor;
import com.deer.wms.produce.manage.model.MtStockProvendorParams;
import com.deer.wms.produce.manage.service.MtStockProvendorService;

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
public class MtStockProvendorServiceImpl extends AbstractService<MtStockProvendor, Integer> implements MtStockProvendorService {

    @Autowired
    private MtStockProvendorMapper mtStockProvendorMapper;


    @Override
    public List<MtStockProvendor> findList(MtStockProvendorParams  params) {
        return mtStockProvendorMapper.findList(params);
    }
}
