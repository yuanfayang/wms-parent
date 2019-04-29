package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_job")
public class MtAloneJob {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

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
     * 启动时间
     */
    @Column(name = "start_time")
    private Date startTime;

    
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
     * 版本号 默认为 1
     */
    private Integer version;

    /**
     * 状态		0处理中，1处理完成
     */
    private Integer processStatus;

    /**
     * 关联流程id
     */
    @Column(name = "task_id")
    private String taskId;
    
    /**
     * 关联流程实例id
     */
    @Column(name = "instance_id")
    private String instanceId;

    /**
     * 作业名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 工艺产品id
     */
    @Column(name = "craft_id")
    private Integer craftId;

    /**
     * 加工数量
     */
    @Column(name = "craft_num")
    private Float craftNum;

    /**
     * 计划整个流程加工费用，单位为元
     */
    @Column(name = "processing_fee")
    private Float processingFee;

    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 工艺 计划开始时间
     */
    @Column(name = "beg_date")
    private Date begDate;

    /**
     * 工艺 计划结束时间， 指整个工艺结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 工艺流程跟踪人 id，关联用户表 user_info
     */
    @Column(name = "tracker_id")
    private Integer trackerId;

    /**
     * 备注
     */
    private String memo;

    /**
     * @return job_id
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
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
     * 获取版本号 默认为 1
     *
     * @return version - 版本号 默认为 1
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1
     *
     * @param version 版本号 默认为 1
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取状态		0处理中，1处理完成
     *
     * @return processStatus - 状态		0处理中，1处理完成
     */
    public Integer getProcessStatus() {
        return processStatus;
    }

    /**
     * 设置状态		0处理中，1处理完成
     *
     * @param processStatus 状态		0处理中，1处理完成
     */
    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * 获取关联流程id
     *
     * @return task_id - 关联流程id
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置关联流程id
     *
     * @param taskId 关联流程id
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
     * 获取作业名称
     *
     * @return job_name - 作业名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置作业名称
     *
     * @param jobName 作业名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取工艺产品id
     *
     * @return craft_id - 工艺产品id
     */
    public Integer getCraftId() {
        return craftId;
    }

    /**
     * 设置工艺产品id
     *
     * @param craftId 工艺产品id
     */
    public void setCraftId(Integer craftId) {
        this.craftId = craftId;
    }

    /**
     * 获取加工数量
     *
     * @return craft_num - 加工数量
     */
    public Float getCraftNum() {
        return craftNum;
    }

    /**
     * 设置加工数量
     *
     * @param craftNum 加工数量
     */
    public void setCraftNum(Float craftNum) {
        this.craftNum = craftNum;
    }

    /**
     * 获取计划整个流程加工费用，单位为元
     *
     * @return processing_fee - 计划整个流程加工费用，单位为元
     */
    public Float getProcessingFee() {
        return processingFee;
    }

    /**
     * 设置计划整个流程加工费用，单位为元
     *
     * @param processingFee 计划整个流程加工费用，单位为元
     */
    public void setProcessingFee(Float processingFee) {
        this.processingFee = processingFee;
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

    /**
     * 获取工艺 计划开始时间
     *
     * @return beg_date - 工艺 计划开始时间
     */
    public Date getBegDate() {
        return begDate;
    }

    /**
     * 设置工艺 计划开始时间
     *
     * @param begDate 工艺 计划开始时间
     */
    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    /**
     * 获取工艺 计划结束时间， 指整个工艺结束时间
     *
     * @return end_date - 工艺 计划结束时间， 指整个工艺结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置工艺 计划结束时间， 指整个工艺结束时间
     *
     * @param endDate 工艺 计划结束时间， 指整个工艺结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取工艺流程跟踪人 id，关联用户表 user_info
     *
     * @return tracker_id - 工艺流程跟踪人 id，关联用户表 user_info
     */
    public Integer getTrackerId() {
        return trackerId;
    }

    /**
     * 设置工艺流程跟踪人 id，关联用户表 user_info
     *
     * @param trackerId 工艺流程跟踪人 id，关联用户表 user_info
     */
    public void setTrackerId(Integer trackerId) {
        this.trackerId = trackerId;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}