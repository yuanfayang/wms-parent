package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_product_batch_detect_det")
public class ProductBatchDetectDet {
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
     * 工序id，关联工序表：mt_alone_process，每个工序都有可能检测
     */
    @Column(name = "process_id")
    private Integer processId;

    /**
     * 卷码code，作为扫描编码
     */
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 检测位置
     */
    private Float position;

    /**
     * 检测瑕疵点id，关联表：mt_alone_fabric_defect
     */
    @Column(name = "defect_id")
    private Integer defectId;

    /**
     * 瑕疵点名称
     */
    @Column(name = "defect_name")
    private String defectName;

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
     * 获取卷码code，作为扫描编码
     *
     * @return product_det_barcode - 卷码code，作为扫描编码
     */
    public String getProductDetBarcode() {
        return productDetBarcode;
    }

    /**
     * 设置卷码code，作为扫描编码
     *
     * @param productDetBarcode 卷码code，作为扫描编码
     */
    public void setProductDetBarcode(String productDetBarcode) {
        this.productDetBarcode = productDetBarcode;
    }

    /**
     * 获取检测位置
     *
     * @return position - 检测位置
     */
    public Float getPosition() {
        return position;
    }

    /**
     * 设置检测位置
     *
     * @param position 检测位置
     */
    public void setPosition(Float position) {
        this.position = position;
    }

    /**
     * 获取检测瑕疵点id，关联表：mt_alone_fabric_defect
     *
     * @return defect_id - 检测瑕疵点id，关联表：mt_alone_fabric_defect
     */
    public Integer getDefectId() {
        return defectId;
    }

    /**
     * 设置检测瑕疵点id，关联表：mt_alone_fabric_defect
     *
     * @param defectId 检测瑕疵点id，关联表：mt_alone_fabric_defect
     */
    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    /**
     * 获取瑕疵点名称
     *
     * @return defect_name - 瑕疵点名称
     */
    public String getDefectName() {
        return defectName;
    }

    /**
     * 设置瑕疵点名称
     *
     * @param defectName 瑕疵点名称
     */
    public void setDefectName(String defectName) {
        this.defectName = defectName;
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