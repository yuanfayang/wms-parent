package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.List;

/**
* Created by  on 2019/09/06.
*/
public class MtAloneStockProductParams extends QueryParams {

    private Integer productTypeId;

    private String productTypeCode;

    private Integer productVarietyId;

    private String begDate;

    private String endDate;

    private List<String> headersName;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public Integer getProductVarietyId() {
        return productVarietyId;
    }

    public void setProductVarietyId(Integer productVarietyId) {
        this.productVarietyId = productVarietyId;
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

    public List<String> getHeadersName() {
        return headersName;
    }

    public void setHeadersName(List<String> headersName) {
        this.headersName = headersName;
    }
}
