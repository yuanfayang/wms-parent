package com.deer.wms.system.manage.service.impl;

import com.deer.wms.system.manage.dao.MtAloneDepartmentGroupMapper;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroup;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentGroupParams;
import com.deer.wms.system.manage.service.MtAloneDepartmentGroupService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/07/15.
 */
@Service
@Transactional
public class MtAloneDepartmentGroupServiceImpl extends AbstractService<MtAloneDepartmentGroup, Integer> implements MtAloneDepartmentGroupService {

    @Autowired
    private MtAloneDepartmentGroupMapper mtAloneDepartmentGroupMapper;


    @Override
    public List<MtAloneDepartmentGroup> findList(MtAloneDepartmentGroupParams params) {
        return mtAloneDepartmentGroupMapper.findList(params);
    }
}
