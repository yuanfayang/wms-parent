package com.deer.wms.system.manage.model.resource;

import com.deer.wms.project.seed.core.service.QueryParams;

public class RouteParams extends QueryParams {
	
	/**
	 * 菜单id
	 */
	private Integer resourceId;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

}
