package com.deer.wms.system.manage.dao;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroup;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroupParams;

import java.util.List;

public interface MtAloneDepartmentGroupMapper extends Mapper<MtAloneDepartmentGroup> {
    List<MtAloneDepartmentGroup> findList(MtAloneDepartmentGroupParams params);
}