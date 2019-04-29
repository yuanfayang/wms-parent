package com.deer.wms.system.manage.model.log;

import com.deer.wms.project.seed.core.service.QueryParams;

public class LogParams extends QueryParams {
	
	private String begDate;
	private String endDate;
	public String getBegDate() {
		return begDate;
	}
	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
