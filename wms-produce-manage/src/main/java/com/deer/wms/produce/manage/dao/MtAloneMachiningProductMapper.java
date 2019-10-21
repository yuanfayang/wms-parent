package com.deer.wms.produce.manage.dao;

import com.deer.wms.produce.manage.model.MachiningProduct;
import com.deer.wms.produce.manage.model.MachiningProductParams;

import com.deer.wms.produce.manage.model.MtAloneMachiningProduct;
import com.deer.wms.project.seed.core.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MtAloneMachiningProductMapper extends Mapper<MtAloneMachiningProduct> {
    List<MachiningProduct> findList(MachiningProductParams params);

    List<MtAloneMachiningProduct> findListByClothAttr(MtAloneMachiningProduct mtAloneMachiningProduct);

    MtAloneMachiningProduct findByProductTypeCode(@Param("productTypeCode") String productTypeCode);

}