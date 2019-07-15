package com.deer.wms.system.manage.service.impl;

import com.deer.wms.system.manage.dao.MtAloneDepartmentMapper;
import com.deer.wms.system.manage.model.department.MtAloneDepartment;
import com.deer.wms.system.manage.model.department.MtAloneDepartmentParams;
import com.deer.wms.system.manage.service.MtAloneDepartmentService;

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
public class MtAloneDepartmentServiceImpl extends AbstractService<MtAloneDepartment, Integer> implements MtAloneDepartmentService {

    @Autowired
    private MtAloneDepartmentMapper mtAloneDepartmentMapper;


    @Override
    public List<MtAloneDepartment> findList(MtAloneDepartmentParams  params) {
        return mtAloneDepartmentMapper.findList(params);
    }
}
