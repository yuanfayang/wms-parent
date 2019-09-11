package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_process_batch_relat")
public class ProcessBatchRelat {
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
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 批次id，关联产品加工批次表：mt_alone_product_process_batch
     */
    @Column(name = "batch_id")
    private Integer batchId;

    /**
     * 工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     */
    @Column(name = "process_id")
    private Integer processId;

    /**
     * 批次号
     */
    @Column(name = "batch_code")
    private String batchCode;

    /**
     * 原先提供长度，单位米
     */
    private Float len;

    /**
     * 配送长度，单位米
     */
    @Column(name = "delivery_len")
    private Float deliveryLen;

    /**
     * 现有检测长度
     */
    @Column(name = "detection_len")
    private Float detectionLen;

    /**
     * 缩率%，现有检测长度/原先长度
     */
    private String shrinkage;

    /**
     * 附件code，关联附件表：mt_alone_accessory
     */
    @Column(name = "product_annex_code")
    private String productAnnexCode;

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
     * 获取批次id，关联产品加工批次表：mt_alone_product_process_batch
     *
     * @return batch_id - 批次id，关联产品加工批次表：mt_alone_product_process_batch
     */
    public Integer getBatchId() {
        return batchId;
    }

    /**
     * 设置批次id，关联产品加工批次表：mt_alone_product_process_batch
     *
     * @param batchId 批次id，关联产品加工批次表：mt_alone_product_process_batch
     */
    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    /**
     * 获取工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     *
     * @return process_id - 工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * 设置工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     *
     * @param processId 工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     */
    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    /**
     * 获取批次号
     *
     * @return batch_code - 批次号
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * 设置批次号
     *
     * @param batchCode 批次号
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * 获取原先提供长度，单位米
     *
     * @return len - 原先提供长度，单位米
     */
    public Float getLen() {
        return len;
    }

    /**
     * 设置原先提供长度，单位米
     *
     * @param len 原先提供长度，单位米
     */
    public void setLen(Float len) {
        this.len = len;
    }

    /**
     * 获取配送长度，单位米
     *
     * @return delivery_len - 配送长度，单位米
     */
    public Float getDeliveryLen() {
        return deliveryLen;
    }

    /**
     * 设置配送长度，单位米
     *
     * @param deliveryLen 配送长度，单位米
     */
    public void setDeliveryLen(Float deliveryLen) {
        this.deliveryLen = deliveryLen;
    }

    /**
     * 获取现有检测长度
     *
     * @return detection_len - 现有检测长度
     */
    public Float getDetectionLen() {
        return detectionLen;
    }

    /**
     * 设置现有检测长度
     *
     * @param detectionLen 现有检测长度
     */
    public void setDetectionLen(Float detectionLen) {
        this.detectionLen = detectionLen;
    }

    /**
     * 获取缩率%，现有检测长度/原先长度
     *
     * @return shrinkage - 缩率%，现有检测长度/原先长度
     */
    public String getShrinkage() {
        return shrinkage;
    }

    /**
     * 设置缩率%，现有检测长度/原先长度
     *
     * @param shrinkage 缩率%，现有检测长度/原先长度
     */
    public void setShrinkage(String shrinkage) {
        this.shrinkage = shrinkage;
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