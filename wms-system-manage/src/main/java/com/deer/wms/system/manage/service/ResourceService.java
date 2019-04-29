package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.resource.Resource;
import com.deer.wms.system.manage.model.resource.ResourceCriteria;
import com.deer.wms.system.manage.model.resource.ResourceParams;

import java.util.List;

import com.deer.wms.project.seed.core.service.Service;

/**
 * Created by WUXB on 2017/10/08.
 */
public interface ResourceService extends Service<Resource, Integer> {

	List<Resource> findResourceByParentId(int parentId);
	List<Resource> findResourceByParentName(String parentName);
	List<Resource> findReourceByName(ResourceCriteria criteria);
	List<Resource> listByKeywords(ResourceParams parmas);

}
