package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/25 13:01
 * @Version 1.0
 */
public class ProcessBomDTO extends ProcessBom{

    private Integer productProcessId;

    private String productProcessName;

    private String companyName;

    @Override
    public Integer getProductProcessId() {
        return productProcessId;
    }

    @Override
    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    public String getProductProcessName() {
        return productProcessName;
    }

    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
