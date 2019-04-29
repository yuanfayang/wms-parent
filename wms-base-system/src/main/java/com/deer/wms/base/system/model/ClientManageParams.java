package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class ClientManageParams extends QueryParams {
	
	private Integer clientId;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
