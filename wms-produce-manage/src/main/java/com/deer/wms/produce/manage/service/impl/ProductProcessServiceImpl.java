package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.ProductProcessMapper;
import com.deer.wms.produce.manage.model.ProductProcess;
import com.deer.wms.produce.manage.model.ProductProcessParams;
import com.deer.wms.produce.manage.service.ProductProcessService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
@Service
@Transactional
public class ProductProcessServiceImpl extends AbstractService<ProductProcess, Integer> implements ProductProcessService {

    @Autowired
    private ProductProcessMapper productProcessMapper;


    @Override
    public List<ProductProcess> findList(ProductProcessParams params) {
        return productProcessMapper.findList(params);
    }
}
