package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MachiningProduct;
import com.deer.wms.produce.manage.model.MachiningProductParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MachiningProductMapper extends Mapper<MachiningProduct> {
    List<MachiningProduct> findList(MachiningProductParams params);

    List<MachiningProduct> findProductList(MachiningProductParams params);

    List<MachiningProduct> findProductHaveBomList(MachiningProductParams params);
}