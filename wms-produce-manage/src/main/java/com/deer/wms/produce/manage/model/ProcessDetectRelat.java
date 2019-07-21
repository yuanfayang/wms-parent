package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_process_detect_relat")
public class ProcessDetectRelat {
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
     * 产品条码code
     */
    @Column(name = "product_bar_code")
    private String productBarCode;

    /**
     * 产品明细code，产品明细code：product_det_code，每一卷布可能有多次检测 
     */
    @Column(name = "product_bar_det_code")
    private String productBarDetCode;

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
     * 获取产品条码code
     *
     * @return product_bar_code - 产品条码code
     */
    public String getProductBarCode() {
        return productBarCode;
    }

    /**
     * 设置产品条码code
     *
     * @param productBarCode 产品条码code
     */
    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    /**
     * 获取产品明细code，产品明细code：product_det_code，每一卷布可能有多次检测 
     *
     * @return product_bar_det_code - 产品明细code，产品明细code：product_det_code，每一卷布可能有多次检测 
     */
    public String getProductBarDetCode() {
        return productBarDetCode;
    }

    /**
     * 设置产品明细code，产品明细code：product_det_code，每一卷布可能有多次检测 
     *
     * @param productBarDetCode 产品明细code，产品明细code：product_det_code，每一卷布可能有多次检测 
     */
    public void setProductBarDetCode(String productBarDetCode) {
        this.productBarDetCode = productBarDetCode;
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