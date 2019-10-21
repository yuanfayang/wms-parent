package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MtStockProvendor;
import com.deer.wms.produce.manage.model.MtStockProvendorParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtStockProvendorMapper extends Mapper<MtStockProvendor> {
    List<MtStockProvendor> findList(MtStockProvendorParams params);
}