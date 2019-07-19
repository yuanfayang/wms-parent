package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_process_bom")
public class ProcessBom {
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
     * 工序名称
     */
    @Column(name = "process_name")
    private String processName;

    /**
     * 产品生产bom的id，关联表：mt_alone_product_process_bom
     */
    @Column(name = "product_process_id")
    private Integer productProcessId;

    /**
     * 规格型号
     */
    private String specification;

    /**
     * 加工描述内容
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 工序步骤，从第一步开始，依次增加
     */
    @Column(name = "process_step")
    private Integer processStep;

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
     * 获取工序名称
     *
     * @return process_name - 工序名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 设置工序名称
     *
     * @param processName 工序名称
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * 获取产品生产bom的id，关联表：mt_alone_product_process_bom
     *
     * @return product_process_id - 产品生产bom的id，关联表：mt_alone_product_process_bom
     */
    public Integer getProductProcessId() {
        return productProcessId;
    }

    /**
     * 设置产品生产bom的id，关联表：mt_alone_product_process_bom
     *
     * @param productProcessId 产品生产bom的id，关联表：mt_alone_product_process_bom
     */
    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    /**
     * 获取规格型号
     *
     * @return specification - 规格型号
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置规格型号
     *
     * @param specification 规格型号
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取加工描述内容
     *
     * @return process_content - 加工描述内容
     */
    public String getProcessContent() {
        return processContent;
    }

    /**
     * 设置加工描述内容
     *
     * @param processContent 加工描述内容
     */
    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    /**
     * 获取工序步骤，从第一步开始，依次增加
     *
     * @return process_step - 工序步骤，从第一步开始，依次增加
     */
    public Integer getProcessStep() {
        return processStep;
    }

    /**
     * 设置工序步骤，从第一步开始，依次增加
     *
     * @param processStep 工序步骤，从第一步开始，依次增加
     */
    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
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