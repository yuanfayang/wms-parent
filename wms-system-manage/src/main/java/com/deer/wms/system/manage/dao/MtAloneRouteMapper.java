package com.deer.wms.system.manage.dao;

import java.util.List;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.MtAloneRoute;
import com.deer.wms.system.manage.model.MtAloneRouteCriteria;
import com.deer.wms.system.manage.model.resource.RouteParams;

public interface MtAloneRouteMapper extends Mapper<MtAloneRoute> {

	/**
	 * @param criteria
	 * @return
	 */
	List<MtAloneRoute> findList(MtAloneRouteCriteria criteria);

	List<MtAloneRoute> findListByResourceId(RouteParams routeParams);

	List<MtAloneRoute> findRouteByParentId(Integer id);
}