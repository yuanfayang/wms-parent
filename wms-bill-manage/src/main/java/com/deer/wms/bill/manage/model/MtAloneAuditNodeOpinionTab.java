package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_audit_node_opinion_tab")
public class MtAloneAuditNodeOpinionTab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作员id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

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
     * 任务模块id
     */
    @Column(name = "audit_task_id")
    private Integer auditTaskId;

    /**
     * 节点id，关联表：mt_alone_audit_relat
     */
    @Column(name = "node_id")
    private Integer nodeId;

    /**
     *  对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     */
    @Column(name = "group_id")
    private Integer groupId;

    /**
     *  审核人id
     */
    @Column(name = "reviewer_id")
    private Integer reviewerId;

    /**
     * 是否审核，0：没有审核，1：审核结束
     */
    @Column(name = "is_audit")
    private Integer isAudit;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 是否同意，0：同意，1：不同意，如果不同意，系统要在节点后面插入一个流程
     */
    @Column(name = "is_agree")
    private Integer isAgree;

    /**
     * 审核意见
     */
    @Column(name = "audit_opinion")
    private String auditOpinion;

    /**
     * 审核节点名称
     */
    @Column(name = "audit_node_name")
    private String auditNodeName;

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
     * 获取任务模块id
     *
     * @return audit_task_id - 任务模块id
     */
    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    /**
     * 设置任务模块id
     *
     * @param auditTaskId 任务模块id
     */
    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    /**
     * 获取节点id，关联表：mt_alone_audit_relat
     *
     * @return node_id - 节点id，关联表：mt_alone_audit_relat
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * 设置节点id，关联表：mt_alone_audit_relat
     *
     * @param nodeId 节点id，关联表：mt_alone_audit_relat
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 获取 对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     *
     * @return group_id -  对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置 对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     *
     * @param groupId  对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取 审核人id
     *
     * @return reviewer_id -  审核人id
     */
    public Integer getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置 审核人id
     *
     * @param reviewerId  审核人id
     */
    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 获取是否审核，0：没有审核，1：审核结束
     *
     * @return is_audit - 是否审核，0：没有审核，1：审核结束
     */
    public Integer getIsAudit() {
        return isAudit;
    }

    /**
     * 设置是否审核，0：没有审核，1：审核结束
     *
     * @param isAudit 是否审核，0：没有审核，1：审核结束
     */
    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取是否同意，0：同意，1：不同意，如果不同意，系统要在节点后面插入一个流程
     *
     * @return is_agree - 是否同意，0：同意，1：不同意，如果不同意，系统要在节点后面插入一个流程
     */
    public Integer getIsAgree() {
        return isAgree;
    }

    /**
     * 设置是否同意，0：同意，1：不同意，如果不同意，系统要在节点后面插入一个流程
     *
     * @param isAgree 是否同意，0：同意，1：不同意，如果不同意，系统要在节点后面插入一个流程
     */
    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    /**
     * 获取审核意见
     *
     * @return audit_opinion - 审核意见
     */
    public String getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpinion 审核意见
     */
    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    /**
     * 获取审核节点名称
     *
     * @return audit_node_name - 审核节点名称
     */
    public String getAuditNodeName() {
        return auditNodeName;
    }

    /**
     * 设置审核节点名称
     *
     * @param auditNodeName 审核节点名称
     */
    public void setAuditNodeName(String auditNodeName) {
        this.auditNodeName = auditNodeName;
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