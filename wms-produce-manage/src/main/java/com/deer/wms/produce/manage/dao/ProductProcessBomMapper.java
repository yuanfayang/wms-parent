package com.deer.wms.ware.task.dao;


import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductProcessBomMapper extends Mapper<ProductProcessBom> {
    List<ProductProcessBom> findList(ProductProcessBomParams params);
}