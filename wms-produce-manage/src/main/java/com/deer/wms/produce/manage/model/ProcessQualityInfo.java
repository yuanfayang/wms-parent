package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_process_quality_info")
public class ProcessQualityInfo {
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
     * 版本号 默认为 1.1
     */
    private Integer version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 工序id，关联工序表：mt_alone_process
     */
    @Column(name = "process_id")
    private Integer processId;

    /**
     * 完成百分比，%
     */
    @Column(name = "complete_ratio")
    private String completeRatio;

    /**
     * 质量信息描述
     */
    @Column(name = "quality_info")
    private String qualityInfo;

    /**
     * 完成匹数
     */
    @Column(name = "completed_num")
    private Integer completedNum;

    /**
     * 附件code，关联附件表：mt_alone_accessory
     */
    @Column(name = "product_annex_code")
    private String productAnnexCode;

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
     * 获取版本号 默认为 1.1
     *
     * @return version - 版本号 默认为 1.1
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(Integer version) {
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
     * 获取工序id，关联工序表：mt_alone_process
     *
     * @return process_id - 工序id，关联工序表：mt_alone_process
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * 设置工序id，关联工序表：mt_alone_process
     *
     * @param processId 工序id，关联工序表：mt_alone_process
     */
    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    /**
     * 获取完成百分比，%
     *
     * @return complete_ratio - 完成百分比，%
     */
    public String getCompleteRatio() {
        return completeRatio;
    }

    /**
     * 设置完成百分比，%
     *
     * @param completeRatio 完成百分比，%
     */
    public void setCompleteRatio(String completeRatio) {
        this.completeRatio = completeRatio;
    }

    /**
     * 获取质量信息描述
     *
     * @return quality_info - 质量信息描述
     */
    public String getQualityInfo() {
        return qualityInfo;
    }

    /**
     * 设置质量信息描述
     *
     * @param qualityInfo 质量信息描述
     */
    public void setQualityInfo(String qualityInfo) {
        this.qualityInfo = qualityInfo;
    }

    /**
     * 获取完成匹数
     *
     * @return completed_num - 完成匹数
     */
    public Integer getCompletedNum() {
        return completedNum;
    }

    /**
     * 设置完成匹数
     *
     * @param completedNum 完成匹数
     */
    public void setCompletedNum(Integer completedNum) {
        this.completedNum = completedNum;
    }

    /**
     * 获取附件code，关联附件表：mt_alone_accessory
     *
     * @return product_annex_code - 附件code，关联附件表：mt_alone_accessory
     */
    public String getProductAnnexCode() {
        return productAnnexCode;
    }

    /**
     * 设置附件code，关联附件表：mt_alone_accessory
     *
     * @param productAnnexCode 附件code，关联附件表：mt_alone_accessory
     */
    public void setProductAnnexCode(String productAnnexCode) {
        this.productAnnexCode = productAnnexCode;
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