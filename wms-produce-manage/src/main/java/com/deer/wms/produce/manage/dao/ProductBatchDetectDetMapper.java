package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProductBatchDetectDet;
import com.deer.wms.produce.manage.model.ProductBatchDetectDetParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductBatchDetectDetMapper extends Mapper<ProductBatchDetectDet> {
    List<ProductBatchDetectDet> findList(ProductBatchDetectDetParams params);
}