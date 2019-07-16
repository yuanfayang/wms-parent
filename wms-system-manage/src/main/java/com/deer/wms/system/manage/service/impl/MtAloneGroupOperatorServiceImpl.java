package com.deer.wms.system.manage.service.impl;

import com.deer.wms.system.manage.dao.MtAloneGroupOperatorMapper;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperator;
import com.deer.wms.system.manage.model.department.MtAloneGroupOperatorParams;
import com.deer.wms.system.manage.service.MtAloneGroupOperatorService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/07/16.
 */
@Service
@Transactional
public class MtAloneGroupOperatorServiceImpl extends AbstractService<MtAloneGroupOperator, Integer> implements MtAloneGroupOperatorService {

    @Autowired
    private MtAloneGroupOperatorMapper mtAloneGroupOperatorMapper;


    @Override
    public List<MtAloneGroupOperator> findList(MtAloneGroupOperatorParams  params) {
        return mtAloneGroupOperatorMapper.findList(params);
    }

    @Override
    public void deleteByGroupId(Integer groupId) {
        mtAloneGroupOperatorMapper.deleteByGroupId(groupId);
    }

    @Override
    public List<MtAloneGroupOperator> findListByGroupId(Integer groupId) {
        return mtAloneGroupOperatorMapper.findListByGroupId(groupId);
    }
}
