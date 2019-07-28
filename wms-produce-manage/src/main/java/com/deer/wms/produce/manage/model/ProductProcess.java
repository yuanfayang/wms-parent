package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_product_process")
public class ProductProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 生产计划单号
     */
    @Column(name = "code")
    private String code;

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
     * 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    @Column(name = "product_bom_id")
    private Integer productBomId;

    /**
     * 加工规格型号
     */
    private String specification;

    /**
     * 加工价格，加工所需要的总费用
     */
    @Column(name = "process_price")
    private Float processPrice;

    /**
     * 原先长度，单位米
     */
    private Float len;

    /**
     * 总匹数
     */
    @Column(name = "pi_num")
    private Integer piNum;

    /**
     * 加工描述内容
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 跟单员id，关联表员工表：user_info
     */
    @Column(name = "merchandiser_id")
    private Integer merchandiserId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 审核状态		0等待审核，1审核通过，2审核失败
     */
    @Column(name = "review_status")
    private Integer reviewStatus;

    /**
     * 审核时间
     */
    @Column(name = "review_time")
    private Date reviewTime;

    /**
     * 审核人id，关联表：user_info
     */
    @Column(name = "reviewer_id")
    private Integer reviewerId;

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

    /**code
     * 获取生产计划单号
     *
     * @return  - 生产计划单号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置生产计划单号
     *
     * @param code 生产计划单号
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     *
     * @return product_bom_id - 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    public Integer getProductBomId() {
        return productBomId;
    }

    /**
     * 设置选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     *
     * @param productBomId 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    public void setProductBomId(Integer productBomId) {
        this.productBomId = productBomId;
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
     * 获取加工价格，加工所需要的总费用
     *
     * @return process_price - 加工价格，加工所需要的总费用
     */
    public Float getProcessPrice() {
        return processPrice;
    }

    /**
     * 设置加工价格，加工所需要的总费用
     *
     * @param processPrice 加工价格，加工所需要的总费用
     */
    public void setProcessPrice(Float processPrice) {
        this.processPrice = processPrice;
    }

    /**
     * 获取原先长度，单位米
     *
     * @return len - 原先长度，单位米
     */
    public Float getLen() {
        return len;
    }

    /**
     * 设置原先长度，单位米
     *
     * @param len 原先长度，单位米
     */
    public void setLen(Float len) {
        this.len = len;
    }

    /**
     * 获取总匹数
     *
     * @return pi_num - 总匹数
     */
    public Integer getPiNum() {
        return piNum;
    }

    /**
     * 设置总匹数
     *
     * @param piNum 总匹数
     */
    public void setPiNum(Integer piNum) {
        this.piNum = piNum;
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
     * 获取跟单员id，关联表员工表：user_info
     *
     * @return merchandiser_id - 跟单员id，关联表员工表：user_info
     */
    public Integer getMerchandiserId() {
        return merchandiserId;
    }

    /**
     * 设置跟单员id，关联表员工表：user_info
     *
     * @param merchandiserId 跟单员id，关联表员工表：user_info
     */
    public void setMerchandiserId(Integer merchandiserId) {
        this.merchandiserId = merchandiserId;
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
     * 获取审核状态		0等待审核，1审核通过，2审核失败
     *
     * @return review_status - 审核状态		0等待审核，1审核通过，2审核失败
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 设置审核状态		0等待审核，1审核通过，2审核失败
     *
     * @param reviewStatus 审核状态		0等待审核，1审核通过，2审核失败
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 获取审核时间
     *
     * @return review_time - 审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 设置审核时间
     *
     * @param reviewTime 审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 获取审核人id，关联表：user_info
     *
     * @return reviewer_id - 审核人id，关联表：user_info
     */
    public Integer getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置审核人id，关联表：user_info
     *
     * @param reviewerId 审核人id，关联表：user_info
     */
    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
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