package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProductBatchDetect;
import com.deer.wms.produce.manage.model.ProductBatchDetectParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductBatchDetectMapper extends Mapper<ProductBatchDetect> {
    List<ProductBatchDetect> findList(ProductBatchDetectParams params);
}