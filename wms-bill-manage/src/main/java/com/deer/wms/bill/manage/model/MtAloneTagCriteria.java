package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/12/30.
*/
public class MtAloneTagCriteria extends QueryCriteria {
	private Integer tagType;
	private String tagCode;
	public Integer getTagType() {
		return tagType;
	}
	public void setTagType(Integer tagType) {
		this.tagType = tagType;
	}
	public String getTagCode() {
		return tagCode;
	}
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	
}
