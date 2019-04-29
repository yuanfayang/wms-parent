package com.deer.wms.system.manage.dao;

import java.util.List;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.MtAloneLog;
import com.deer.wms.system.manage.model.MtAloneLogCriteria;
import com.deer.wms.system.manage.model.log.LogParams;

public interface MtAloneLogMapper extends Mapper<MtAloneLog> {

	/**
	 * @param criteria
	 * @return
	 */
	List<MtAloneLog> findList(MtAloneLogCriteria criteria);

	List<MtAloneLog> findListNew(LogParams params);
}