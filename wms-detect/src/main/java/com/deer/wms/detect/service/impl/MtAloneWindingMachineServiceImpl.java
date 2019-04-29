package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneWindingMachineMapper;
import com.deer.wms.detect.model.MtAloneWindingMachine;
import com.deer.wms.detect.model.MtAloneWindingMachineCriteria;
import com.deer.wms.detect.service.MtAloneWindingMachineService;

import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.deer.wms.detect.model.MtAloneWindingMachineParams;

/**
 * Created by guo on 2019/03/21.
 */
@Service
@Transactional
public class MtAloneWindingMachineServiceImpl extends AbstractService<MtAloneWindingMachine, Integer> implements MtAloneWindingMachineService {

    @Autowired
    private MtAloneWindingMachineMapper mtAloneWindingMachineMapper;


    @Override
    public List<MtAloneWindingMachine> findList(MtAloneWindingMachineParams  params) {
        return mtAloneWindingMachineMapper.findList(params);
    }
}
