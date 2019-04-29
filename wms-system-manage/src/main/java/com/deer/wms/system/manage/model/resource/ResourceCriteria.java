package com.deer.wms.system.manage.model.resource;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by WUXB on 2017/10/07.
*/
public class ResourceCriteria extends QueryCriteria {
	private String resourceName;

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}
