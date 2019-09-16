package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtAloneStockProduct;
import com.deer.wms.produce.manage.model.MtAloneStockProductParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneStockProductMapper extends Mapper<MtAloneStockProduct> {
    List<MtAloneStockProduct> findList(MtAloneStockProductParams params);

    List<MtAloneStockProduct> findListPart(MtAloneStockProductParams params);

}