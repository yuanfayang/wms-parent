package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductProcessBomMapper;
import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomDto;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.produce.manage.service.ProductProcessBomService;


import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by guo on 2019/07/18.
 */
@Service
@Transactional
public class ProductProcessBomServiceImpl extends AbstractService<ProductProcessBom, Integer> implements ProductProcessBomService {

    @Autowired
    private ProductProcessBomMapper productProcessBomMapper;


    @Override
    public List<ProductProcessBomDto> findProBomAndProList(ProductProcessBomParams params) {
        return productProcessBomMapper.findProBomAndProList(params);
    }

    @Override
    public List<ProductProcessBomDto> findListByTerm(ProductProcessBomParams params) {
        return productProcessBomMapper.findListByTerm(params);
    }

    @Override
    public List<ProductProcessBom> findListByProductId(ProductProcessBomParams params) {
        return productProcessBomMapper.findListByProductId(params);
    }
}
