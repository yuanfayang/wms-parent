package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by gtt on 2019/07/18.
*/
public class MtAloneAuditNodeTaskParams extends QueryParams {

    private Integer auditTaskId;

    private String auditUrl;
    //1-通过，0-不通过
    private Integer isPass;

    private Integer currentId;

    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    public String getAuditUrl() { return auditUrl; }

    public void setAuditUrl(String auditUrl) { this.auditUrl = auditUrl; }

    public Integer getIsPass() { return isPass; }

    public void setIsPass(Integer isPass) { this.isPass = isPass; }

    public Integer getCurrentId() { return currentId; }

    public void setCurrentId(Integer currentId) { this.currentId = currentId; }
}
