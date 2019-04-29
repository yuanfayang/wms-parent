package com.deer.wms.base.system.dao;

import com.deer.wms.base.system.model.SupplierManage;
import com.deer.wms.base.system.model.SupplierManageCriteria;
import com.deer.wms.base.system.model.SupplierManageParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface SupplierManageMapper extends Mapper<SupplierManage> {
    void deleteByCodeAndCom(SupplierManageCriteria criteria);
    List<SupplierManage> findList(SupplierManageCriteria criteria);

    List<SupplierManage> findListNew(SupplierManageParams params);

    void deleteByIdAndCom(SupplierManageParams params);

    Integer countRelProducts(SupplierManageParams params);
}