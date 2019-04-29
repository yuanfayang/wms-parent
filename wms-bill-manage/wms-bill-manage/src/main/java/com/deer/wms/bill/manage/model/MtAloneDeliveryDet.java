package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_delivery_det")
public class MtAloneDeliveryDet {
    /**
     * 主键id
     */
    @Id
    @Column(name = "delivery_det_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryDetId;

    /**
     * 明细的条形码
     */
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 产品的条形码
     */
    @Column(name = "product_barcode")
    private String productBarcode;

    /**
     * 出库长度
     */
    @Column(name = "delivery_length")
    private Float deliveryLength;

    /**
     * 创建时间
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
    @Column(name = "create_man_id")
    private Integer createManId;

    /**
     * 备注
     */
    private String notes;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;

    /**
     * 关联公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 版本号
     */
    private String version;

    /**
     * 出库单号
     */
    @Column(name = "delivery_order_code")
    private String deliveryOrderCode;

    /**
     * 获取主键id
     *
     * @return delivery_det_id - 主键id
     */
    public Integer getDeliveryDetId() {
        return deliveryDetId;
    }

    /**
     * 设置主键id
     *
     * @param deliveryDetId 主键id
     */
    public void setDeliveryDetId(Integer deliveryDetId) {
        this.deliveryDetId = deliveryDetId;
    }

    /**
     * 获取明细的条形码
     *
     * @return product_det_barcode - 明细的条形码
     */
    public String getProductDetBarcode() {
        return productDetBarcode;
    }

    /**
     * 设置明细的条形码
     *
     * @param productDetBarcode 明细的条形码
     */
    public void setProductDetBarcode(String productDetBarcode) {
        this.productDetBarcode = productDetBarcode;
    }

    /**
     * 获取产品的条形码
     *
     * @return product_barcode - 产品的条形码
     */
    public String getProductBarcode() {
        return productBarcode;
    }

    /**
     * 设置产品的条形码
     *
     * @param productBarcode 产品的条形码
     */
    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    /**
     * 获取出库长度
     *
     * @return delivery_length - 出库长度
     */
    public Float getDeliveryLength() {
        return deliveryLength;
    }

    /**
     * 设置出库长度
     *
     * @param deliveryLength 出库长度
     */
    public void setDeliveryLength(Float deliveryLength) {
        this.deliveryLength = deliveryLength;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
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
     * @return create_man_id - 创建人id
     */
    public Integer getCreateManId() {
        return createManId;
    }

    /**
     * 设置创建人id
     *
     * @param createManId 创建人id
     */
    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 获取状态 delete-删除 normal-正常
     *
     * @return state - 状态 delete-删除 normal-正常
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态 delete-删除 normal-正常
     *
     * @param state 状态 delete-删除 normal-正常
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取关联公司id
     *
     * @return company_id - 关联公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置关联公司id
     *
     * @param companyId 关联公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取出库单号
     *
     * @return delivery_order_code - 出库单号
     */
    public String getDeliveryOrderCode() {
        return deliveryOrderCode;
    }

    /**
     * 设置出库单号
     *
     * @param deliveryOrderCode 出库单号
     */
    public void setDeliveryOrderCode(String deliveryOrderCode) {
        this.deliveryOrderCode = deliveryOrderCode;
    }
}