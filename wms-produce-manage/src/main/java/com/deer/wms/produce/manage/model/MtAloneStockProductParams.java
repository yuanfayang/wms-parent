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

    private String sort;

    private String firstLargeClass;

    private String specification;

    private String density;

    private String grammage;

    private String salesPrice;

    private String productCode;

    private String productName;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFirstLargeClass() {
        return firstLargeClass;
    }

    public void setFirstLargeClass(String firstLargeClass) {
        this.firstLargeClass = firstLargeClass;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getGrammage() {
        return grammage;
    }

    public void setGrammage(String grammage) {
        this.grammage = grammage;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

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
