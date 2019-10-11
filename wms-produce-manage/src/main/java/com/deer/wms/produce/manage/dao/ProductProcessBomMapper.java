package com.deer.wms.produce.manage.dao;


import com.deer.wms.produce.manage.model.ProductProcessBom;
import com.deer.wms.produce.manage.model.ProductProcessBomDto;
import com.deer.wms.produce.manage.model.ProductProcessBomParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface ProductProcessBomMapper extends Mapper<ProductProcessBom> {
    List<ProductProcessBomDto> findProBomAndProList(ProductProcessBomParams params);
    List<ProductProcessBom> findList(ProductProcessBomParams params);

    List<ProductProcessBomDto> findListByTerm(ProductProcessBomParams params);
}