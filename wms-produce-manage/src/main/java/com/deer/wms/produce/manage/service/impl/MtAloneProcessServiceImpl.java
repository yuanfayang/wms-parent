package com.deer.wms.produce.manage.service.impl;

import com.deer.wms.produce.manage.dao.MtAloneProcessMapper;
import com.deer.wms.produce.manage.model.MtAloneProcess;
import com.deer.wms.produce.manage.model.MtAloneProcessParams;
import com.deer.wms.produce.manage.service.MtAloneProcessService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
@Service
@Transactional
public class MtAloneProcessServiceImpl extends AbstractService<MtAloneProcess, Integer> implements MtAloneProcessService {

    @Autowired
    private MtAloneProcessMapper mtAloneProcessMapper;


    //@Override
    //public List<MtAloneProcess> findList(MtAloneProcessParams params) {
    //    return mtAloneProcessMapper.findList(params);
    //}
}
