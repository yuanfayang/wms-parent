package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_sample_cloth_out")
public class MtAloneSampleClothOut {
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
    private Integer creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Integer updaterId;

    /**
     * 版本号 默认为 1
     */
    private String version;

    /**
     * 状态		0处理中，1处理完成
     */
    private Integer status;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 客户id，关联表，mt_customer
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 是否货到付邮费	0货到客户付邮寄费，1公司出邮寄费
     */
    @Column(name = "is_pay")
    private Integer isPay;

    /**
     * 本次累计花费的所有费用
     */
    @Column(name = "cumulative_fee")
    private Float cumulativeFee;

    /**
     * 本次客户花费的总邮寄费用
     */
    @Column(name = "customer_postage_fees")
    private Float customerPostageFees;

    /**
     * 本次客户购买的布所花费的总费用
     */
    @Column(name = "customer_purchase_cost")
    private Float customerPurchaseCost;

    /**
     * 本次公司邮寄所花费的总费，单位为元
     */
    @Column(name = "postage_fees")
    private Float postageFees;

    /**
     * 附件code， 关联附件表：mt_alone_accessory
     */
    @Column(name = "annex_code")
    private String annexCode;

    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

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
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取更新人id
     *
     * @return updater_id - 更新人id
     */
    public Integer getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 获取版本号 默认为 1
     *
     * @return version - 版本号 默认为 1
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1
     *
     * @param version 版本号 默认为 1
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取状态		0处理中，1处理完成
     *
     * @return status - 状态		0处理中，1处理完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0处理中，1处理完成
     *
     * @param status 状态		0处理中，1处理完成
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取客户id，关联表，mt_customer
     *
     * @return customer_id - 客户id，关联表，mt_customer
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id，关联表，mt_customer
     *
     * @param customerId 客户id，关联表，mt_customer
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取是否货到付邮费	0货到客户付邮寄费，1公司出邮寄费
     *
     * @return is_pay - 是否货到付邮费	0货到客户付邮寄费，1公司出邮寄费
     */
    public Integer getIsPay() {
        return isPay;
    }

    /**
     * 设置是否货到付邮费	0货到客户付邮寄费，1公司出邮寄费
     *
     * @param isPay 是否货到付邮费	0货到客户付邮寄费，1公司出邮寄费
     */
    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    /**
     * 获取本次累计花费的所有费用
     *
     * @return cumulative_fee - 本次累计花费的所有费用
     */
    public Float getCumulativeFee() {
        return cumulativeFee;
    }

    /**
     * 设置本次累计花费的所有费用
     *
     * @param cumulativeFee 本次累计花费的所有费用
     */
    public void setCumulativeFee(Float cumulativeFee) {
        this.cumulativeFee = cumulativeFee;
    }

    /**
     * 获取本次客户花费的总邮寄费用
     *
     * @return customer_postage_fees - 本次客户花费的总邮寄费用
     */
    public Float getCustomerPostageFees() {
        return customerPostageFees;
    }

    /**
     * 设置本次客户花费的总邮寄费用
     *
     * @param customerPostageFees 本次客户花费的总邮寄费用
     */
    public void setCustomerPostageFees(Float customerPostageFees) {
        this.customerPostageFees = customerPostageFees;
    }

    /**
     * 获取本次客户购买的布所花费的总费用
     *
     * @return customer_purchase_cost - 本次客户购买的布所花费的总费用
     */
    public Float getCustomerPurchaseCost() {
        return customerPurchaseCost;
    }

    /**
     * 设置本次客户购买的布所花费的总费用
     *
     * @param customerPurchaseCost 本次客户购买的布所花费的总费用
     */
    public void setCustomerPurchaseCost(Float customerPurchaseCost) {
        this.customerPurchaseCost = customerPurchaseCost;
    }

    /**
     * 获取本次公司邮寄所花费的总费，单位为元
     *
     * @return postage_fees - 本次公司邮寄所花费的总费，单位为元
     */
    public Float getPostageFees() {
        return postageFees;
    }

    /**
     * 设置本次公司邮寄所花费的总费，单位为元
     *
     * @param postageFees 本次公司邮寄所花费的总费，单位为元
     */
    public void setPostageFees(Float postageFees) {
        this.postageFees = postageFees;
    }

    /**
     * 获取附件code， 关联附件表：mt_alone_accessory
     *
     * @return annex_code - 附件code， 关联附件表：mt_alone_accessory
     */
    public String getAnnexCode() {
        return annexCode;
    }

    /**
     * 设置附件code， 关联附件表：mt_alone_accessory
     *
     * @param annexCode 附件code， 关联附件表：mt_alone_accessory
     */
    public void setAnnexCode(String annexCode) {
        this.annexCode = annexCode;
    }

    /**
     * 获取备注1
     *
     * @return remark1 - 备注1
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 设置备注1
     *
     * @param remark1 备注1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 获取备注2
     *
     * @return remark2 - 备注2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 设置备注2
     *
     * @param remark2 备注2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}