package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_return_order")
public class MtAloneReturnOrder {
    /**
     * 退货单id
     */
    @Id
    @Column(name = "return_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer returnId;

    /**
     * 退货单号
     */
    @Column(name = "return_order_code")
    private String returnOrderCode;

    /**
     * 退货产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 退货产品条形码
     */
    @Column(name = "product_bar_code")
    private String productBarCode;

    /**
     * 退货总米数
     */
    @Column(name = "product_length")
    private Float productLength;

    /**
     * 退货单价
     */
    @Column(name = "product_unit_price")
    private Float productUnitPrice;

    /**
     * 退货时间
     */
    @Column(name = "return_time")
    private Date returnTime;

    /**
     * 退货客户名称
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * 退货客户地址
     */
    @Column(name = "client_address")
    private String clientAddress;

    /**
     * 运输费用
     */
    @Column(name = "express_fee")
    private Float expressFee;

    /**
     * 联系人姓名
     */
    @Column(name = "linkman_name")
    private String linkmanName;

    /**
     * 联系人电话
     */
    @Column(name = "linkman_phone_number")
    private String linkmanPhoneNumber;

    /**
     * 备注
     */
    private String memo;

    /**
     * 审核状态（0未通过/1通过/2待审核）
     */
    @Column(name = "reviewe_state")
    private Integer revieweState;

    /**
     * 退货总价
     */
    @Column(name = "product_total_price")
    private Float productTotalPrice;

    /**
     * 获取退货单id
     *
     * @return return_id - 退货单id
     */
    public Integer getReturnId() {
        return returnId;
    }

    /**
     * 设置退货单id
     *
     * @param returnId 退货单id
     */
    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    /**
     * 获取退货单号
     *
     * @return return_order_code - 退货单号
     */
    public String getReturnOrderCode() {
        return returnOrderCode;
    }

    /**
     * 设置退货单号
     *
     * @param returnOrderCode 退货单号
     */
    public void setReturnOrderCode(String returnOrderCode) {
        this.returnOrderCode = returnOrderCode;
    }

    /**
     * 获取退货产品名称
     *
     * @return product_name - 退货产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置退货产品名称
     *
     * @param productName 退货产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取退货产品条形码
     *
     * @return product_bar_code - 退货产品条形码
     */
    public String getProductBarCode() {
        return productBarCode;
    }

    /**
     * 设置退货产品条形码
     *
     * @param productBarCode 退货产品条形码
     */
    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    /**
     * 获取退货总米数
     *
     * @return product_length - 退货总米数
     */
    public Float getProductLength() {
        return productLength;
    }

    /**
     * 设置退货总米数
     *
     * @param productLength 退货总米数
     */
    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    /**
     * 获取退货单价
     *
     * @return product_unit_price - 退货单价
     */
    public Float getProductUnitPrice() {
        return productUnitPrice;
    }

    /**
     * 设置退货单价
     *
     * @param productUnitPrice 退货单价
     */
    public void setProductUnitPrice(Float productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    /**
     * 获取退货时间
     *
     * @return return_time - 退货时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 设置退货时间
     *
     * @param returnTime 退货时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * 获取退货客户名称
     *
     * @return client_name - 退货客户名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置退货客户名称
     *
     * @param clientName 退货客户名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取退货客户地址
     *
     * @return client_address - 退货客户地址
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * 设置退货客户地址
     *
     * @param clientAddress 退货客户地址
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * 获取运输费用
     *
     * @return express_fee - 运输费用
     */
    public Float getExpressFee() {
        return expressFee;
    }

    /**
     * 设置运输费用
     *
     * @param expressFee 运输费用
     */
    public void setExpressFee(Float expressFee) {
        this.expressFee = expressFee;
    }

    /**
     * 获取联系人姓名
     *
     * @return linkman_name - 联系人姓名
     */
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * 设置联系人姓名
     *
     * @param linkmanName 联系人姓名
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /**
     * 获取联系人电话
     *
     * @return linkman_phone_number - 联系人电话
     */
    public String getLinkmanPhoneNumber() {
        return linkmanPhoneNumber;
    }

    /**
     * 设置联系人电话
     *
     * @param linkmanPhoneNumber 联系人电话
     */
    public void setLinkmanPhoneNumber(String linkmanPhoneNumber) {
        this.linkmanPhoneNumber = linkmanPhoneNumber;
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
     * 获取审核状态（0未通过/1通过/2待审核）
     *
     * @return reviewe_state - 审核状态（0未通过/1通过/2待审核）
     */
    public Integer getRevieweState() {
        return revieweState;
    }

    /**
     * 设置审核状态（0未通过/1通过/2待审核）
     *
     * @param revieweState 审核状态（0未通过/1通过/2待审核）
     */
    public void setRevieweState(Integer revieweState) {
        this.revieweState = revieweState;
    }

    /**
     * 获取退货总价
     *
     * @return product_total_price - 退货总价
     */
    public Float getProductTotalPrice() {
        return productTotalPrice;
    }

    /**
     * 设置退货总价
     *
     * @param productTotalPrice 退货总价
     */
    public void setProductTotalPrice(Float productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }
}