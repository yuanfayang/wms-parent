package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/25 13:05
 * @Version 1.0
 */
public class ProcessMaterialsBomDto extends ProcessMaterialsBom {

    private Integer productProcessId;

    private String productProcessName;

    private Integer processId;

    private String processName;

    private String materialsName;

    private String companyName;

    public Integer getProductProcessId() {
        return productProcessId;
    }

    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    public String getProductProcessName() {
        return productProcessName;
    }

    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }
}
