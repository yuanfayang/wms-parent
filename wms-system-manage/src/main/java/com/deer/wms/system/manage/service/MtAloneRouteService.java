package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.MtAloneRoute;
import com.deer.wms.system.manage.model.MtAloneRouteCriteria;
import com.deer.wms.system.manage.model.resource.RouteParams;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/01/31.
 */
public interface MtAloneRouteService extends Service<MtAloneRoute, Integer> {


    List<MtAloneRoute> findList(MtAloneRouteCriteria  criteria) ;

	List<MtAloneRoute> findListByResourceId(RouteParams routeParams);

	List<MtAloneRoute> findRouteByParentId(Integer id);

}
