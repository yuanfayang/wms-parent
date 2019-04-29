package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.MtAloneWindingMachine;
import com.deer.wms.detect.model.MtAloneWindingMachineParams;
import com.deer.wms.project.seed.core.mapper.Mapper;


public interface MtAloneWindingMachineMapper extends Mapper<MtAloneWindingMachine> {

	List<MtAloneWindingMachine> findList(MtAloneWindingMachineParams params);
}