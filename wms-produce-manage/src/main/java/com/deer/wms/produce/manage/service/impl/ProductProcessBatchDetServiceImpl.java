package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductProcessBatchDetMapper;
import com.deer.wms.produce.manage.model.ProductProcessBatchDet;
import com.deer.wms.produce.manage.model.ProductProcessBatchDetParams;
import com.deer.wms.produce.manage.service.ProductProcessBatchDetService;

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
public class ProductProcessBatchDetServiceImpl extends AbstractService<ProductProcessBatchDet, Integer> implements ProductProcessBatchDetService {

    @Autowired
    private ProductProcessBatchDetMapper productProcessBatchDetMapper;


    @Override
    public List<ProductProcessBatchDet> findList(ProductProcessBatchDetParams  params) {
        return productProcessBatchDetMapper.findList(params);
    }
}
