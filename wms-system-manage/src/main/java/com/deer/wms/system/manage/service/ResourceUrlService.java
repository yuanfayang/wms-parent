package com.deer.wms.system.manage.service;

import com.deer.wms.system.manage.model.resource.ResourceUrl;

import java.util.List;

import com.deer.wms.project.seed.core.service.Service;

/**
 * Created by WUXB on 2017/10/07.
 */
public interface ResourceUrlService extends Service<ResourceUrl, Integer> {

	List<ResourceUrl> getUrlsByResourceId(Integer resourceId);

}
