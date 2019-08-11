package com.deer.wms.bill.manage.service.impl;

import com.deer.wms.bill.manage.dao.MtAloneUserTaskMapper;
import com.deer.wms.bill.manage.model.MtAloneUserTask;
import com.deer.wms.bill.manage.model.MtAloneUserTaskParams;
import com.deer.wms.bill.manage.service.MtAloneUserTaskService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by gtt on 2019/08/11.
 */
@Service
@Transactional
public class MtAloneUserTaskServiceImpl extends AbstractService<MtAloneUserTask, Integer> implements MtAloneUserTaskService {

    @Autowired
    private MtAloneUserTaskMapper mtAloneUserTaskMapper;


    @Override
    public List<MtAloneUserTask> findList(MtAloneUserTaskParams  params) {
        return mtAloneUserTaskMapper.findList(params);
    }
}
