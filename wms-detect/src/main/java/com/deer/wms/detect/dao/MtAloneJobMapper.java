package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.MtAloneJob;
import com.deer.wms.detect.model.MtAloneJobParams;
import com.deer.wms.detect.model.MtAloneJobVo;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneJobMapper extends Mapper<MtAloneJob> {

	/**
	 * @param params
	 * @return
	 */
	List<MtAloneJobVo> findList(MtAloneJobParams params);
}