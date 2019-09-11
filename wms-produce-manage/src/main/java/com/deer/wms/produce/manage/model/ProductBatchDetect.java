package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_product_batch_detect")
public class ProductBatchDetect {
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
     * 卷码code，作为扫描编码，关联表：mt_alone_product_process_batch_det
     */
    @Column(name = "batch_det_code")
    private String batchDetCode;

    /**
     * 明细编码，对应产品卷布编码，不同工序布卷不同编码，根据不同情况系统自行生成
     */
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 等级，1为一等品，2：二等品，3：等品。。。
     */
    private Integer grade;

    /**
     * 打卷机id，关联表：mt_alone_winding_machine
     */
    @Column(name = "winding_machine_id")
    private Integer windingMachineId;

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
     * 获取卷码code，作为扫描编码，关联表：mt_alone_product_process_batch_det
     *
     * @return batch_det_code - 卷码code，作为扫描编码，关联表：mt_alone_product_process_batch_det
     */
    public String getBatchDetCode() {
        return batchDetCode;
    }

    /**
     * 设置卷码code，作为扫描编码，关联表：mt_alone_product_process_batch_det
     *
     * @param batchDetCode 卷码code，作为扫描编码，关联表：mt_alone_product_process_batch_det
     */
    public void setBatchDetCode(String batchDetCode) {
        this.batchDetCode = batchDetCode;
    }

    /**
     * 获取明细编码，对应产品卷布编码，不同工序布卷不同编码，根据不同情况系统自行生成
     *
     * @return product_det_barcode - 明细编码，对应产品卷布编码，不同工序布卷不同编码，根据不同情况系统自行生成
     */
    public String getProductDetBarcode() {
        return productDetBarcode;
    }

    /**
     * 设置明细编码，对应产品卷布编码，不同工序布卷不同编码，根据不同情况系统自行生成
     *
     * @param productDetBarcode 明细编码，对应产品卷布编码，不同工序布卷不同编码，根据不同情况系统自行生成
     */
    public void setProductDetBarcode(String productDetBarcode) {
        this.productDetBarcode = productDetBarcode;
    }

    /**
     * 获取等级，1为一等品，2：二等品，3：等品。。。
     *
     * @return grade - 等级，1为一等品，2：二等品，3：等品。。。
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置等级，1为一等品，2：二等品，3：等品。。。
     *
     * @param grade 等级，1为一等品，2：二等品，3：等品。。。
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取打卷机id，关联表：mt_alone_winding_machine
     *
     * @return winding_machine_id - 打卷机id，关联表：mt_alone_winding_machine
     */
    public Integer getWindingMachineId() {
        return windingMachineId;
    }

    /**
     * 设置打卷机id，关联表：mt_alone_winding_machine
     *
     * @param windingMachineId 打卷机id，关联表：mt_alone_winding_machine
     */
    public void setWindingMachineId(Integer windingMachineId) {
        this.windingMachineId = windingMachineId;
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