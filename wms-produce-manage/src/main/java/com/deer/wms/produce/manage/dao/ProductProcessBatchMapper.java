package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.ProductProcessBatch;
import com.deer.wms.produce.manage.model.ProductProcessBatchParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductProcessBatchMapper extends Mapper<ProductProcessBatch> {
    List<ProductProcessBatch> findList(ProductProcessBatchParams params);
}