package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_sample_cloth_out_det")
public class MtAloneSampleClothOutDet {
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
     * 样布出库表：mt_alone_sample_cloth_out
     */
    @Column(name = "sample_cloth_out_id")
    private Integer sampleClothOutId;

    /**
     * 是否免费，对样布本身的费用	0不免费，1免费
     */
    @Column(name = "is_free")
    private Integer isFree;

    /**
     * 客户购买的布所花费的费用
     */
    @Column(name = "customer_purchase_cost")
    private Float customerPurchaseCost;

    /**
     * 是否为库存记录	0是库存记录，1不是库存记录
     */
    @Column(name = "is_stock")
    private Integer isStock;

    /**
     * 样布明细id，如果是库存出库，相应的库存要减掉库存
     */
    @Column(name = "sample_cloth_det_id")
    private Integer sampleClothDetId;

    /**
     * 附件code， 关联附件表：mt_alone_accessory
     */
    @Column(name = "annex_code")
    private String annexCode;

    /**
     * 样布单价(每米/元)
     */
    @Column(name = "sample_cloth_price")
    private Float sampleClothPrice;

    /**
     * 样布长度
     */
    @Column(name = "sample_cloth_length")
    private Float sampleClothLength;

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
     * 获取样布出库表：mt_alone_sample_cloth_out
     *
     * @return sample_cloth_out_id - 样布出库表：mt_alone_sample_cloth_out
     */
    public Integer getSampleClothOutId() {
        return sampleClothOutId;
    }

    /**
     * 设置样布出库表：mt_alone_sample_cloth_out
     *
     * @param sampleClothOutId 样布出库表：mt_alone_sample_cloth_out
     */
    public void setSampleClothOutId(Integer sampleClothOutId) {
        this.sampleClothOutId = sampleClothOutId;
    }

    /**
     * 获取是否免费，对样布本身的费用	0不免费，1免费
     *
     * @return is_free - 是否免费，对样布本身的费用	0不免费，1免费
     */
    public Integer getIsFree() {
        return isFree;
    }

    /**
     * 设置是否免费，对样布本身的费用	0不免费，1免费
     *
     * @param isFree 是否免费，对样布本身的费用	0不免费，1免费
     */
    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    /**
     * 获取客户购买的布所花费的费用
     *
     * @return customer_purchase_cost - 客户购买的布所花费的费用
     */
    public Float getCustomerPurchaseCost() {
        return customerPurchaseCost;
    }

    /**
     * 设置客户购买的布所花费的费用
     *
     * @param customerPurchaseCost 客户购买的布所花费的费用
     */
    public void setCustomerPurchaseCost(Float customerPurchaseCost) {
        this.customerPurchaseCost = customerPurchaseCost;
    }

    /**
     * 获取是否为库存记录	0是库存记录，1不是库存记录
     *
     * @return is_stock - 是否为库存记录	0是库存记录，1不是库存记录
     */
    public Integer getIsStock() {
        return isStock;
    }

    /**
     * 设置是否为库存记录	0是库存记录，1不是库存记录
     *
     * @param isStock 是否为库存记录	0是库存记录，1不是库存记录
     */
    public void setIsStock(Integer isStock) {
        this.isStock = isStock;
    }

    /**
     * 获取样布明细id，如果是库存出库，相应的库存要减掉库存
     *
     * @return sample_cloth_det_id - 样布明细id，如果是库存出库，相应的库存要减掉库存
     */
    public Integer getSampleClothDetId() {
        return sampleClothDetId;
    }

    /**
     * 设置样布明细id，如果是库存出库，相应的库存要减掉库存
     *
     * @param sampleClothDetId 样布明细id，如果是库存出库，相应的库存要减掉库存
     */
    public void setSampleClothDetId(Integer sampleClothDetId) {
        this.sampleClothDetId = sampleClothDetId;
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
     * 获取样布单价(每米/元)
     *
     * @return sample_cloth_price - 样布单价(每米/元)
     */
    public Float getSampleClothPrice() {
        return sampleClothPrice;
    }

    /**
     * 设置样布单价(每米/元)
     *
     * @param sampleClothPrice 样布单价(每米/元)
     */
    public void setSampleClothPrice(Float sampleClothPrice) {
        this.sampleClothPrice = sampleClothPrice;
    }

    /**
     * 获取样布长度
     *
     * @return sample_cloth_length - 样布长度
     */
    public Float getSampleClothLength() {
        return sampleClothLength;
    }

    /**
     * 设置样布长度
     *
     * @param sampleClothLength 样布长度
     */
    public void setSampleClothLength(Float sampleClothLength) {
        this.sampleClothLength = sampleClothLength;
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