package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_audit_relat_mb")
public class MtAloneAuditRelatMb {
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
    @Column(name = "audit_task_MB_id")
    private Integer auditTaskMbId;

    /**
     * 节点顺序，第一个节点为1，没有上一个节点，最后一个节点为后续没有节点
     */
    @Column(name = "node_order")
    private Integer nodeOrder;

    /**
     * 上一个节点id，如果没有上一个节点为0
     */
    @Column(name = "prev_node_id")
    private Integer prevNodeId;

    /**
     * 下一个节点id，如果没有下一个节点为0
     */
    @Column(name = "next_node_id")
    private Integer nextNodeId;

    /**
     *  对应审核人员组id，可能有多个审核人员，关联部门组表：mt_alone_department_group
     */
    @Column(name = "group_id")
    private Integer groupId;

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
     * @return audit_task_MB_id - 任务模块id
     */
    public Integer getAuditTaskMbId() {
        return auditTaskMbId;
    }

    /**
     * 设置任务模块id
     *
     * @param auditTaskMbId 任务模块id
     */
    public void setAuditTaskMbId(Integer auditTaskMbId) {
        this.auditTaskMbId = auditTaskMbId;
    }

    /**
     * 获取节点顺序，第一个节点为1，没有上一个节点，最后一个节点为后续没有节点
     *
     * @return node_order - 节点顺序，第一个节点为1，没有上一个节点，最后一个节点为后续没有节点
     */
    public Integer getNodeOrder() {
        return nodeOrder;
    }

    /**
     * 设置节点顺序，第一个节点为1，没有上一个节点，最后一个节点为后续没有节点
     *
     * @param nodeOrder 节点顺序，第一个节点为1，没有上一个节点，最后一个节点为后续没有节点
     */
    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    /**
     * 获取上一个节点id，如果没有上一个节点为0
     *
     * @return prev_node_id - 上一个节点id，如果没有上一个节点为0
     */
    public Integer getPrevNodeId() {
        return prevNodeId;
    }

    /**
     * 设置上一个节点id，如果没有上一个节点为0
     *
     * @param prevNodeId 上一个节点id，如果没有上一个节点为0
     */
    public void setPrevNodeId(Integer prevNodeId) {
        this.prevNodeId = prevNodeId;
    }

    /**
     * 获取下一个节点id，如果没有下一个节点为0
     *
     * @return next_node_id - 下一个节点id，如果没有下一个节点为0
     */
    public Integer getNextNodeId() {
        return nextNodeId;
    }

    /**
     * 设置下一个节点id，如果没有下一个节点为0
     *
     * @param nextNodeId 下一个节点id，如果没有下一个节点为0
     */
    public void setNextNodeId(Integer nextNodeId) {
        this.nextNodeId = nextNodeId;
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