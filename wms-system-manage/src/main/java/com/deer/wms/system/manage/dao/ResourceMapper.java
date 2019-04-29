package com.deer.wms.system.manage.dao;

import java.util.List;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.resource.Resource;
import com.deer.wms.system.manage.model.resource.ResourceCriteria;
import com.deer.wms.system.manage.model.resource.ResourceParams;

public interface ResourceMapper extends Mapper<Resource> {

	List<Resource> findResourceByParentId(int parentId);

	List<Resource> findResourceByParentName(String parentName);
	
	List<Resource> findReourceByName(ResourceCriteria criteria);

	List<Resource> listByKeywords(ResourceParams parmas);
}