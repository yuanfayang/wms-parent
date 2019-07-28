package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by gtt on 2019/07/18.
*/
public class MtAloneAuditNodeTaskParams extends QueryParams {

    private Integer auditTaskId;

    private String auditUrl;
    //0-通过，1-不通过
    private Integer is_pass;
    //nodeOrderNow表示操作之后的下一个节点，也就是当前节点，如果没有下一个节点了，将其置为0
//    private Integer nodeOrderNow=0;
//    //0表示整个审核流程没有结束，1表示整个审核流程审核完成，也就是最后一个节点有没有完成
//    private Integer isAudit=0;
//
//    public Integer getIsAudit() {
//        return isAudit;
//    }
//
//    public void setIsAudit(Integer isAudit) {
//        this.isAudit = isAudit;
//    }

    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    public String getAuditUrl() { return auditUrl; }

    public void setAuditUrl(String auditUrl) { this.auditUrl = auditUrl; }

    public Integer getIs_pass() { return is_pass; }

    public void setIs_pass(Integer is_pass) { this.is_pass = is_pass; }

    //    public Integer getNodeOrderNow() {
//        return nodeOrderNow;
//    }
//
//    public void setNodeOrderNow(Integer nodeOrderNow) {
//        this.nodeOrderNow = nodeOrderNow;
//    }
}
