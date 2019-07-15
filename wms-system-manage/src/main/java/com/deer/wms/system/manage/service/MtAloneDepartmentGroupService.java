package com.deer.wms.system.manage.service;


import com.deer.wms.project.seed.core.service.Service;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroup;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroupParams;

import java.util.List;

/**
 * Created by gtt on 2019/07/15.
 */
public interface MtAloneDepartmentGroupService extends Service<MtAloneDepartmentGroup, Integer> {


    List<MtAloneDepartmentGroup> findList(MtAloneDepartmentGroupParams params) ;

}
