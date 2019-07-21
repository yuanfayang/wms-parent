package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by gtt on 2019/07/18.
*/
public class MtAloneAuditRelatParams extends QueryParams {

    private Integer auditTaskId;

    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }
}
