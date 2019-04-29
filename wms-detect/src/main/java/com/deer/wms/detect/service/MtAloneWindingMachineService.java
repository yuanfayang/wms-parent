package com.deer.wms.detect.service;

import com.deer.wms.detect.model.MtAloneWindingMachine;
import com.deer.wms.detect.model.MtAloneWindingMachineCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.detect.model.MtAloneWindingMachineParams;

/**
 * Created by guo on 2019/03/21.
 */
public interface MtAloneWindingMachineService extends Service<MtAloneWindingMachine, Integer> {


    List<MtAloneWindingMachine> findList(MtAloneWindingMachineParams  params) ;

}
