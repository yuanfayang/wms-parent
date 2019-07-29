package com.deer.wms.produce.manage.dao;


import com.deer.wms.produce.manage.model.ProductProcess;
import com.deer.wms.produce.manage.model.ProductProcessParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductProcessMapper extends Mapper<ProductProcess> {
    List<ProductProcess> findList(ProductProcessParams params);
}