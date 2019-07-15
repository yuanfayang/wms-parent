package com.deer.wms.system.manage.dao;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.department.MtAloneDepartment;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentParams;

import java.util.List;

public interface MtAloneDepartmentMapper extends Mapper<MtAloneDepartment> {
    List<MtAloneDepartment> findList(MtAloneDepartmentParams params);
}