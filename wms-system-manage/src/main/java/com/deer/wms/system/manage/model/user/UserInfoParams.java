package com.deer.wms.system.manage.model.user;

import com.deer.wms.project.seed.core.service.QueryParams;

public class UserInfoParams extends QueryParams {
	private Integer companyId;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
