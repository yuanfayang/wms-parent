package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneStockProductMapper;
import com.deer.wms.produce.manage.model.MtAloneStockProduct;
import com.deer.wms.produce.manage.model.MtAloneStockProductParams;
import com.deer.wms.produce.manage.service.MtAloneStockProductService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/06.
 */
@Service
@Transactional
public class MtAloneStockProductServiceImpl extends AbstractService<MtAloneStockProduct, Integer> implements MtAloneStockProductService {

    @Autowired
    private MtAloneStockProductMapper mtAloneStockProductMapper;


    @Override
    public List<MtAloneStockProduct> findList(MtAloneStockProductParams  params) {
        return mtAloneStockProductMapper.findList(params);
    }

    @Override
    public List<MtAloneStockProduct> findListPart(MtAloneStockProductParams params) {
        return mtAloneStockProductMapper.findListPart(params);
    }
}
