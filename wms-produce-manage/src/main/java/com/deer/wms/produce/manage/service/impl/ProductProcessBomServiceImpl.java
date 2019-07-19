package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.produce.manage.service.ProductProcessBomService;
import com.deer.wms.ware.task.dao.ProductProcessBomMapper;


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


    //@Override
    //public List<ProductProcessBom> findList(ProductProcessBomParams params) {
    //    return productProcessBomMapper.findList(params);
    //}
}
