package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_inbound_order")
public class MtAloneInboundOrder {
    /**
     * 入库单id
     */
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
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Long updaterId;

    /**
     * 版本号 默认为 1.1
     */
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 出库单号
     */
    @Column(name = "inbound_order_code")
    private String inboundOrderCode;

    /**
     * 部门id，关联部门表
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 入库类型
     */
    @Column(name = "inbound_type")
    private String inboundType;

    /**
     * 供应商id，关联供应商表：mt_alone_processor
     */
    @Column(name = "processor_id")
    private Integer processorId;

    /**
     * 供应商名称
     */
    @Column(name = "processor_name")
    private String processorName;

    /**
     * 订单号
     */
    @Column(name = "order_code")
    private String orderCode;

    /**
     * 关联审核表，在创建表单时后台根据模块来生成所有审核节点，然后吧所有的审核节点插入到审核关联表中
     */
    @Column(name = "audit_task_id")
    private Integer auditTaskId;

    /**
     * 是否审核任务，初始为0:表示新建节点，1：已经有审核但是没有审核结束，2：审核完成
     */
    @Column(name = "is_audit_task")
    private Integer isAuditTask;

    /**
     * 审核状态（2审核不通过/1审核通过/0待审核）
     */
    @Column(name = "reviewe_state")
    private Integer revieweState;

    /**
     * 录入人员名字
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 采购员id
     */
    @Column(name = "buyer_id")
    private Integer buyerId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 仓库名称
     */
    private String wareName;

    /**
     * 获取入库单id
     *
     * @return id - 入库单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置入库单id
     *
     * @param id 入库单id
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取更新人id
     *
     * @return updater_id - 更新人id
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
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
     * 获取出库单号
     *
     * @return inbound_order_code - 出库单号
     */
    public String getInboundOrderCode() {
        return inboundOrderCode;
    }

    /**
     * 设置出库单号
     *
     * @param inboundOrderCode 出库单号
     */
    public void setInboundOrderCode(String inboundOrderCode) {
        this.inboundOrderCode = inboundOrderCode;
    }

    /**
     * 获取部门id，关联部门表
     *
     * @return department_id - 部门id，关联部门表
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门id，关联部门表
     *
     * @param departmentId 部门id，关联部门表
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取入库类型
     *
     * @return inbound_type - 入库类型
     */
    public String getInboundType() {
        return inboundType;
    }

    /**
     * 设置入库类型
     *
     * @param inboundType 入库类型
     */
    public void setInboundType(String inboundType) {
        this.inboundType = inboundType;
    }

    /**
     * 获取供应商id，关联供应商表：mt_alone_processor
     *
     * @return processor_id - 供应商id，关联供应商表：mt_alone_processor
     */
    public Integer getProcessorId() {
        return processorId;
    }

    /**
     * 设置供应商id，关联供应商表：mt_alone_processor
     *
     * @param processorId 供应商id，关联供应商表：mt_alone_processor
     */
    public void setProcessorId(Integer processorId) {
        this.processorId = processorId;
    }

    /**
     * 获取供应商名称
     *
     * @return processor_name - 供应商名称
     */
    public String getProcessorName() {
        return processorName;
    }

    /**
     * 设置供应商名称
     *
     * @param processorName 供应商名称
     */
    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    /**
     * 获取订单号
     *
     * @return order_code - 订单号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置订单号
     *
     * @param orderCode 订单号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 获取关联审核表，在创建表单时后台根据模块来生成所有审核节点，然后吧所有的审核节点插入到审核关联表中
     *
     * @return audit_task_id - 关联审核表，在创建表单时后台根据模块来生成所有审核节点，然后吧所有的审核节点插入到审核关联表中
     */
    public Integer getAuditTaskId() {
        return auditTaskId;
    }

    /**
     * 设置关联审核表，在创建表单时后台根据模块来生成所有审核节点，然后吧所有的审核节点插入到审核关联表中
     *
     * @param auditTaskId 关联审核表，在创建表单时后台根据模块来生成所有审核节点，然后吧所有的审核节点插入到审核关联表中
     */
    public void setAuditTaskId(Integer auditTaskId) {
        this.auditTaskId = auditTaskId;
    }

    /**
     * 获取是否审核任务，初始为0:表示新建节点，1：已经有审核但是没有审核结束，2：审核完成
     *
     * @return is_audit_task - 是否审核任务，初始为0:表示新建节点，1：已经有审核但是没有审核结束，2：审核完成
     */
    public Integer getIsAuditTask() {
        return isAuditTask;
    }

    /**
     * 设置是否审核任务，初始为0:表示新建节点，1：已经有审核但是没有审核结束，2：审核完成
     *
     * @param isAuditTask 是否审核任务，初始为0:表示新建节点，1：已经有审核但是没有审核结束，2：审核完成
     */
    public void setIsAuditTask(Integer isAuditTask) {
        this.isAuditTask = isAuditTask;
    }

    /**
     * 获取审核状态（2审核不通过/1审核通过/0待审核）
     *
     * @return reviewe_state - 审核状态（2审核不通过/1审核通过/0待审核）
     */
    public Integer getRevieweState() {
        return revieweState;
    }

    /**
     * 设置审核状态（2审核不通过/1审核通过/0待审核）
     *
     * @param revieweState 审核状态（2审核不通过/1审核通过/0待审核）
     */
    public void setRevieweState(Integer revieweState) {
        this.revieweState = revieweState;
    }

    /**
     * 获取录入人员名字
     *
     * @return operator_name - 录入人员名字
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置录入人员名字
     *
     * @param operatorName 录入人员名字
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取采购员id
     *
     * @return buyer_id - 采购员id
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * 设置采购员id
     *
     * @param buyerId 采购员id
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
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
     * 获取绑定公司id
     *
     * @return company_id - 绑定公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置绑定公司id
     *
     * @param companyId 绑定公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取仓库名称
     *
     * @return ware_name - 仓库名称
     */
    public String getWareName() { return wareName; }

    /**
     * 设置仓库名称
     *
     * @param wareName 仓库名称
     */
    public void setWareName(String wareName) { this.wareName = wareName; }
}