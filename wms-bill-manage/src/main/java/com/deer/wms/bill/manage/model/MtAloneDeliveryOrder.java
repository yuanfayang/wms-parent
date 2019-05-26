package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_delivery_order")
public class MtAloneDeliveryOrder {
    /**
     * 出库单id
     */
    @Id
    @Column(name = "delivery_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryOrderId;

    /**
     * 出库单号
     */
    @Column(name = "delivery_order_code")
    private String deliveryOrderCode;

    /**
     * 出库商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 出库商品条形码
     */
    @Column(name = "product_bar_code")
    private String productBarCode;

    /**
     * 出库总米数
     */
    @Column(name = "product_length")
    private Float productLength;

    /**
     * 出库单价
     */
    @Column(name = "product_price")
    private Float productPrice;

    /**
     * 出库时间
     */
    @Column(name = "delivery_time")
    private Date deliveryTime;

    /**
     * 客户名称
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * 客户地址
     */
    @Column(name = "client_address")
    private String clientAddress;

    /**
     * 是否自提（0不自提/1自提）
     */
    @Column(name = "is_selfhelp_taking")
    private Integer isSelfhelpTaking;

    /**
     * 运输公司名称
     */
    @Column(name = "express_company_name")
    private String expressCompanyName;

    /**
     * 运输单号
     */
    @Column(name = "tracking_number")
    private String trackingNumber;

    /**
     * 运输费用
     */
    @Column(name = "express_fee")
    private Float expressFee;

    /**
     * 运输方式
     */
    @Column(name = "express_type")
    private Integer expressType;

    /**
     * 备注
     */
    private String memo;

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
     * 审核状态（0审核不通过/1审核通过/2待审核）
     */
    @Column(name = "reviewe_state")
    private Integer revieweState;

    /**
     * 录入人员名字
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 录入人员编号
     */
    @Column(name = "operator_code")
    private String operatorCode;

    /**
     * 出库状态（0表示销售出库/1表示退给供应商）
     */
    @Column(name = "delivery_state")
    private Integer deliveryState;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;
    
    /**
     *  创建时间
    */
   @Column(name = "create_time")
   private Date createTime;
    
    
   /**
    *  修改时间
   */
   @Column(name = "update_time")
   private Date updateTime;


    /**
     * 绑定销售员id
     */
    @Column(name = "salesperson_id")
    private Integer salespersonId;

    /**
     * 获取出库单id
     *
     * @return delivery_order_id - 出库单id
     */
    public Integer getDeliveryOrderId() {
        return deliveryOrderId;
    }

    /**
     * 设置出库单id
     *
     * @param deliveryOrderId 出库单id
     */
    public void setDeliveryOrderId(Integer deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
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

    /**
     * 获取出库商品名称
     *
     * @return product_name - 出库商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置出库商品名称
     *
     * @param productName 出库商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取出库商品条形码
     *
     * @return product_bar_code - 出库商品条形码
     */
    public String getProductBarCode() {
        return productBarCode;
    }

    /**
     * 设置出库商品条形码
     *
     * @param productBarCode 出库商品条形码
     */
    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    /**
     * 获取出库总米数
     *
     * @return product_length - 出库总米数
     */
    public Float getProductLength() {
        return productLength;
    }

    /**
     * 设置出库总米数
     *
     * @param productLength 出库总米数
     */
    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    /**
     * 获取出库单价
     *
     * @return product_price - 出库单价
     */
    public Float getProductPrice() {
        return productPrice;
    }

    /**
     * 设置出库单价
     *
     * @param productPrice 出库单价
     */
    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取出库时间
     *
     * @return delivery_time - 出库时间
     */
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置出库时间
     *
     * @param deliveryTime 出库时间
     */
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取客户名称
     *
     * @return client_name - 客户名称
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置客户名称
     *
     * @param clientName 客户名称
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取客户地址
     *
     * @return client_address - 客户地址
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * 设置客户地址
     *
     * @param clientAddress 客户地址
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * 获取是否自提（0不自提/1自提）
     *
     * @return is_selfhelp_taking - 是否自提（0不自提/1自提）
     */
    public Integer getIsSelfhelpTaking() {
        return isSelfhelpTaking;
    }

    /**
     * 设置是否自提（0不自提/1自提）
     *
     * @param isSelfhelpTaking 是否自提（0不自提/1自提）
     */
    public void setIsSelfhelpTaking(Integer isSelfhelpTaking) {
        this.isSelfhelpTaking = isSelfhelpTaking;
    }

    /**
     * 获取运输公司名称
     *
     * @return express_company_name - 运输公司名称
     */
    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    /**
     * 设置运输公司名称
     *
     * @param expressCompanyName 运输公司名称
     */
    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    /**
     * 获取运输单号
     *
     * @return tracking_number - 运输单号
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * 设置运输单号
     *
     * @param trackingNumber 运输单号
     */
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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
     * 获取运输方式
     *
     * @return express_type - 运输方式
     */
    public Integer getExpressType() {
        return expressType;
    }

    /**
     * 设置运输方式
     *
     * @param expressType 运输方式
     */
    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
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
     * 获取审核状态（0审核不通过/1审核通过/2待审核）
     *
     * @return reviewe_state - 审核状态（0审核不通过/1审核通过/2待审核）
     */
    public Integer getRevieweState() {
        return revieweState;
    }

    /**
     * 设置审核状态（0审核不通过/1审核通过/2待审核）
     *
     * @param revieweState 审核状态（0审核不通过/1审核通过/2待审核）
     */
    public void setRevieweState(Integer revieweState) {
        this.revieweState = revieweState;
    }

    /**
     * 获取录入人员名字
     *
     * @return operator_name - 录入人员名字
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置录入人员名字
     *
     * @param operatorName 录入人员名字
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取录入人员编号
     *
     * @return operator_code - 录入人员编号
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * 设置录入人员编号
     *
     * @param operatorCode 录入人员编号
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    /**
     * 获取出库状态（0表示销售出库/1表示退给供应商）
     *
     * @return delivery_state - 出库状态（0表示销售出库/1表示退给供应商）
     */
    public Integer getDeliveryState() {
        return deliveryState;
    }

    /**
     * 设置出库状态（0表示销售出库/1表示退给供应商）
     *
     * @param deliveryState 出库状态（0表示销售出库/1表示退给供应商）
     */
    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

    /**
     * 获取绑定销售员id
     *
     * @return salesperson_id - 绑定销售员id
     */
    public Integer getSalespersonId() {
        return salespersonId;
    }

    /**
     * 设置绑定销售员id
     *
     * @param salespersonId 绑定销售员id
     */
    public void setSalespersonId(Integer salespersonId) {
        this.salespersonId = salespersonId;
    }
}