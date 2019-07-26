package com.deer.wms.bill.manage.model;

import java.util.Date;
import java.util.List;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneProductParams extends QueryParams{
	private Integer companyId;
	
	private String productTypeCode;

    private String productVarietyCode;
	
	private String begDate;
	
	private String endDate;

	private List<String> headersName;

	public List<String> getHeadersName() {
		return headersName;
	}

	public void setHeadersName(List<String> headersName) {
		this.headersName = headersName;
	}

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
