package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProductProcessBatchDet;
import com.deer.wms.produce.manage.model.ProductProcessBatchDetParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductProcessBatchDetMapper extends Mapper<ProductProcessBatchDet> {
    List<ProductProcessBatchDet> findList(ProductProcessBatchDetParams params);
}