package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductProcessBatchMapper;
import com.deer.wms.produce.manage.model.ProductProcessBatch;
import com.deer.wms.produce.manage.model.ProductProcessBatchParams;
import com.deer.wms.produce.manage.service.ProductProcessBatchService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
@Service
@Transactional
public class ProductProcessBatchServiceImpl extends AbstractService<ProductProcessBatch, Integer> implements ProductProcessBatchService {

    @Autowired
    private ProductProcessBatchMapper productProcessBatchMapper;


    @Override
    public List<ProductProcessBatch> findList(ProductProcessBatchParams  params) {
        return productProcessBatchMapper.findList(params);
    }
}
