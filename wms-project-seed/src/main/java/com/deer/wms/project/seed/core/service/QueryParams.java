package com.deer.wms.project.seed.core.service;

public abstract class QueryParams {
	
	/**
     * 页码
     */
    private Integer pageNum =1;

    /**
     * 每页显示的条数
     */
    private Integer pageSize =199999;
    
    /**
     * 关键字
     */
    private String keywords = "";
    
    /**
     * 关联公司id
     */
	private Integer companyId = -999;


	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
    

}
