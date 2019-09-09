package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductBatchDetectDetMapper;
import com.deer.wms.produce.manage.model.ProductBatchDetectDet;
import com.deer.wms.produce.manage.model.ProductBatchDetectDetParams;
import com.deer.wms.produce.manage.service.ProductBatchDetectDetService;

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
public class ProductBatchDetectDetServiceImpl extends AbstractService<ProductBatchDetectDet, Integer> implements ProductBatchDetectDetService {

    @Autowired
    private ProductBatchDetectDetMapper productBatchDetectDetMapper;


    @Override
    public List<ProductBatchDetectDet> findList(ProductBatchDetectDetParams  params) {
        return productBatchDetectDetMapper.findList(params);
    }
}
