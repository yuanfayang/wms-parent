package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductBatchDetectMapper;
import com.deer.wms.produce.manage.model.ProductBatchDetect;
import com.deer.wms.produce.manage.model.ProductBatchDetectParams;
import com.deer.wms.produce.manage.service.ProductBatchDetectService;

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
public class ProductBatchDetectServiceImpl extends AbstractService<ProductBatchDetect, Integer> implements ProductBatchDetectService {

    @Autowired
    private ProductBatchDetectMapper productBatchDetectMapper;


    @Override
    public List<ProductBatchDetect> findList(ProductBatchDetectParams  params) {
        return productBatchDetectMapper.findList(params);
    }
}
