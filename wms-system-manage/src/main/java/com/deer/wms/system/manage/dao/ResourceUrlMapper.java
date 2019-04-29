package com.deer.wms.system.manage.dao;

import java.util.List;

import com.deer.wms.project.seed.core.mapper.Mapper;
import com.deer.wms.system.manage.model.resource.ResourceUrl;

public interface ResourceUrlMapper extends Mapper<ResourceUrl> {

	List<ResourceUrl> getUrlsByResourceId(Integer resourceId);
}