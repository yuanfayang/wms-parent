package com.deer.wms.bill.manage.model;

import java.util.Date;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneProductParams extends QueryParams{
	private Integer companyId;
	
	private String productTypeCode;

    private String productVarietyCode;
	
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

	public String getProductTypeCode() {
		return productTypeCode;
	}

	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}

    public String getProductVarietyCode() {
        return productVarietyCode;
    }

    public void setProductVarietyCode(String productVarietyCode) {
        this.productVarietyCode = productVarietyCode;
    }

    public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
