package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_audit_task")
public class MtAloneAuditTask {
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
     * 任务名称
     */
    @Column(name = "audit_task_name")
    private String auditTaskName;

    /**
     * 任务模块id，关联模板表；mt_alone_audit_task_MB
     */
    @Column(name = "audit_task_MB_id")
    private Integer auditTaskMbId;

    /**
     * 针对整个任务是否完成，0：审核没有结束，1：审核结束
     */
    @Column(name = "is_task_completed")
    private Integer isTaskCompleted;

    /**
     * 自动生成，规则：AT-日期到秒
     */
    @Column(name = "audit_task_code")
    private String auditTaskCode;

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
     * 获取任务名称
     *
     * @return audit_task_name - 任务名称
     */
    public String getAuditTaskName() {
        return auditTaskName;
    }

    /**
     * 设置任务名称
     *
     * @param auditTaskName 任务名称
     */
    public void setAuditTaskName(String auditTaskName) {
        this.auditTaskName = auditTaskName;
    }

    /**
     * 获取任务模块id，关联模板表；mt_alone_audit_task_MB
     *
     * @return audit_task_MB_id - 任务模块id，关联模板表；mt_alone_audit_task_MB
     */
    public Integer getAuditTaskMbId() {
        return auditTaskMbId;
    }

    /**
     * 设置任务模块id，关联模板表；mt_alone_audit_task_MB
     *
     * @param auditTaskMbId 任务模块id，关联模板表；mt_alone_audit_task_MB
     */
    public void setAuditTaskMbId(Integer auditTaskMbId) {
        this.auditTaskMbId = auditTaskMbId;
    }

    /**
     * 获取针对整个任务是否完成，0：审核没有结束，1：审核结束
     *
     * @return is_task_completed - 针对整个任务是否完成，0：审核没有结束，1：审核结束
     */
    public Integer getIsTaskCompleted() {
        return isTaskCompleted;
    }

    /**
     * 设置针对整个任务是否完成，0：审核没有结束，1：审核结束
     *
     * @param isTaskCompleted 针对整个任务是否完成，0：审核没有结束，1：审核结束
     */
    public void setIsTaskCompleted(Integer isTaskCompleted) {
        this.isTaskCompleted = isTaskCompleted;
    }

    /**
     * 获取自动生成，规则：AT-日期到秒
     *
     * @return audit_task_code - 自动生成，规则：AT-日期到秒
     */
    public String getAuditTaskCode() {
        return auditTaskCode;
    }

    /**
     * 设置自动生成，规则：AT-日期到秒
     *
     * @param auditTaskCode 自动生成，规则：AT-日期到秒
     */
    public void setAuditTaskCode(String auditTaskCode) {
        this.auditTaskCode = auditTaskCode;
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