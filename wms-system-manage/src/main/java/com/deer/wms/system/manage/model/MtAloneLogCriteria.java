package com.deer.wms.system.manage.model;


import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2019/01/17.
*/
public class MtAloneLogCriteria extends QueryCriteria {
	
	//关键字
	private String keyword;
	//开始时间
	private String begDate;
	//结束时间
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
