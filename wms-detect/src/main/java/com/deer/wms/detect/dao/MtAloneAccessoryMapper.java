package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.MtAloneAccessory;
import com.deer.wms.detect.model.MtAloneAccessoryParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneAccessoryMapper extends Mapper<MtAloneAccessory> {

	List<MtAloneAccessory> findList(MtAloneAccessoryParams params);
}