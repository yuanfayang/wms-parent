package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.MtAloneCraft;
import com.deer.wms.detect.model.MtAloneCraftParams;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneCraftMapper extends Mapper<MtAloneCraft> {

	/**
	 * @param params
	 * @return
	 */
	List<MtAloneCraft> findList(MtAloneCraftParams params);

	/**
	 * @param params
	 * @return
	 */
	List<MtAloneCraft> parentListById(MtAloneCraftParams params);
}