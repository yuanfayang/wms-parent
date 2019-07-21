package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by gtt on 2019/07/18.
*/
public class MtAloneAuditRelatMbParams extends QueryParams {

    private Integer auditTaskMBId;

    public Integer getAuditTaskMBId() {
        return auditTaskMBId;
    }

    public void setAuditTaskMBId(Integer auditTaskMBId) {
        this.auditTaskMBId = auditTaskMBId;
    }
}
