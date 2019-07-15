package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.department.MtAloneDepartment;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/15.
 */
public interface MtAloneDepartmentService extends Service<MtAloneDepartment, Integer> {


    List<MtAloneDepartment> findList(MtAloneDepartmentParams  params) ;

}
