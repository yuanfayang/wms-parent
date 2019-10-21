package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_product_process_bom")
public class MtAloneProductProcessBom {
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
     * 产品加工总名称
     */
    @Column(name = "product_process_name")
    private String productProcessName;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 产品id，关联表：mt_alone_machining_product
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 加工规格型号
     */
    private String specification;

    /**
     * 加工描述内容
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 备注
     */
    private String memo;

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
     * 获取产品加工总名称
     *
     * @return product_process_name - 产品加工总名称
     */
    public String getProductProcessName() {
        return productProcessName;
    }

    /**
     * 设置产品加工总名称
     *
     * @param productProcessName 产品加工总名称
     */
    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取产品id，关联表：mt_alone_machining_product
     *
     * @return product_id - 产品id，关联表：mt_alone_machining_product
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id，关联表：mt_alone_machining_product
     *
     * @param productId 产品id，关联表：mt_alone_machining_product
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取加工规格型号
     *
     * @return specification - 加工规格型号
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置加工规格型号
     *
     * @param specification 加工规格型号
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