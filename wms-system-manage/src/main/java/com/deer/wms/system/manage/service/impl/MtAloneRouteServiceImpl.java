package com.deer.wms.system.manage.service.impl;

import com.deer.wms.system.manage.dao.MtAloneRouteMapper;
import com.deer.wms.system.manage.model.MtAloneRoute;
import com.deer.wms.system.manage.model.MtAloneRouteCriteria;
import com.deer.wms.system.manage.model.resource.RouteParams;
import com.deer.wms.system.manage.service.MtAloneRouteService;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by  on 2019/01/31.
 */
@Service
@Transactional
public class MtAloneRouteServiceImpl extends AbstractService<MtAloneRoute, Integer> implements MtAloneRouteService {

    @Autowired
    private MtAloneRouteMapper mtAloneRouteMapper;


    @Override
    public List<MtAloneRoute> findList(MtAloneRouteCriteria  criteria) {
        return mtAloneRouteMapper.findList(criteria);
    }


	@Override
	public List<MtAloneRoute> findListByResourceId(RouteParams routeParams) {
		// TODO Auto-generated method stub
		return mtAloneRouteMapper.findListByResourceId(routeParams);
	}


	@Override
	public List<MtAloneRoute> findRouteByParentId(Integer id) {
		// TODO Auto-generated method stub
		return mtAloneRouteMapper.findRouteByParentId(id);
	}
}
