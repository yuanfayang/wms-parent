package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_audit_node_task")
public class MtAloneAuditNodeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作员id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 操作员name
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 版本号 默认为 1.1
     */
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 任务模块id，关联表：mt_alone_audit_task
     */
    @Column(name = "audit_task_id")
    private Integer auditTaskId;

    /**
     * 任务模块名称
     */
    @Column(name = "audit_task_name")
    private String auditTaskName;

    /**
     * 当前任务节点id，关联表：mt_alone_audit_relat
     */
    @Column(name = "current_audit_node_id")
    private Integer currentAuditNodeId;

    /**
     * 当前审核节点名称
     */
    @Column(name = "current_audit_node_name")
    private String currentAuditNodeName;

    /**
     * 审核人id
     */
    @Column(name = "reviewer_id")
    private Integer reviewerId;

    /**
     * 是否审核，0：没有审核完成，1：审核结束，2：作废
     */
    @Column(name = "is_audit")
    private Integer isAudit;

    /**
     * 审核时间，最新审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 审核表单url，连接地址
     */
    @Column(name = "audit_url")
    private String auditUrl;

    /**
     * 备注
     */
    private String memo;

    @Column(name = "company_id")
    private Integer companyId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作员id
     *
     * @return operator_id - 操作员id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员id
     *
     * @param operatorId 操作员id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取版本号 默认为 1.1
     *
     * @return version - 版本号 默认为 1.1
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取状态		0使用，1禁用
     *
     * @return status - 状态		0使用，1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0使用，1禁用
     *
     * @param status 状态		0使用，1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取任务模块id，关联表：mt_alone_audit_task
     *
     * @return audit_task_id - 任务模块id，关联表：mt_alone_audit_task
     */
    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    /**
     * 设置任务模块id，关联表：mt_alone_audit_task
     *
     * @param auditTaskId 任务模块id，关联表：mt_alone_audit_task
     */
    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    /**
     * 获取任务模块名称
     *
     * @return audit_task_name - 任务模块名称
     */
    public String getAuditTaskName() {
        return auditTaskName;
    }

    /**
     * 设置任务模块名称
     *
     * @param auditTaskName 任务模块名称
     */
    public void setAuditTaskName(String auditTaskName) {
        this.auditTaskName = auditTaskName;
    }

    /**
     * 获取当前任务节点id，关联表：mt_alone_audit_relat
     *
     * @return current_audit_node_id - 当前任务节点id，关联表：mt_alone_audit_relat
     */
    public Integer getCurrentAuditNodeId() {
        return currentAuditNodeId;
    }

    /**
     * 设置当前任务节点id，关联表：mt_alone_audit_relat
     *
     * @param currentAuditNodeId 当前任务节点id，关联表：mt_alone_audit_relat
     */
    public void setCurrentAuditNodeId(Integer currentAuditNodeId) {
        this.currentAuditNodeId = currentAuditNodeId;
    }

    /**
     * 获取当前审核节点名称
     *
     * @return current_audit_node_name - 当前审核节点名称
     */
    public String getCurrentAuditNodeName() {
        return currentAuditNodeName;
    }

    /**
     * 设置当前审核节点名称
     *
     * @param currentAuditNodeName 当前审核节点名称
     */
    public void setCurrentAuditNodeName(String currentAuditNodeName) {
        this.currentAuditNodeName = currentAuditNodeName;
    }

    /**
     * 获取审核人id
     *
     * @return reviewer_id - 审核人id
     */
    public Integer getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置审核人id
     *
     * @param reviewerId 审核人id
     */
    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 获取是否审核，0：没有审核完成，1：审核结束，2：作废
     *
     * @return is_audit - 是否审核，0：没有审核完成，1：审核结束，2：作废
     */
    public Integer getIsAudit() {
        return isAudit;
    }

    /**
     * 设置是否审核，0：没有审核完成，1：审核结束，2：作废
     *
     * @param isAudit 是否审核，0：没有审核完成，1：审核结束，2：作废
     */
    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    /**
     * 获取审核时间，最新审核时间
     *
     * @return audit_time - 审核时间，最新审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间，最新审核时间
     *
     * @param auditTime 审核时间，最新审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取审核表单url，连接地址
     *
     * @return audit_url - 审核表单url，连接地址
     */
    public String getAuditUrl() {
        return auditUrl;
    }

    /**
     * 设置审核表单url，连接地址
     *
     * @param auditUrl 审核表单url，连接地址
     */
    public void setAuditUrl(String auditUrl) {
        this.auditUrl = auditUrl;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}