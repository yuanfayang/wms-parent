package com.deer.wms.bill.manage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MtAloneFlowRecordsVo extends MtAloneProduct{
    /**
     * 记录id
     */
    @Id
    @Column(name = "flow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowId;

    /**
     * 产品明细条形码
     */
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 产品条形码
     */
    @Column(name = "product_barcode")
    private String productBarcode;

    /**
     * 产品出库单号
     */
    @Column(name = "delivery_order_code")
    private String deliveryOrderCode;

    /**
     * 产品明细退货时间
     */
    @Column(name = "product_det_returntime")
    private Date productDetReturntime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 退货状态（0已出库后退货/1未出库退货）
     */
    @Column(name = "return_state")
    private Integer returnState;

    /**
     * (0表示入库流/1出库流水/2退货流水)
     */
    @Column(name = "flowcode_state")
    private Integer flowcodeState;

    /**
     * 产品明细入库时间
     */
    @Column(name = "product_det_waretime")
    private Date productDetWaretime;

    /**
     * 产品明细出库时间
     */
    @Column(name = "product_det_deliverytime")
    private Date productDetDeliverytime;

    /**
     * 出货长度
     */
    @Column(name = "delivery_length")
    private Float deliveryLength;

    /**
     * 出库条形码
     */
    @Column(name = "delivery_barcode")
    private String deliveryBarcode;

    /**
     * 退货单号
     */
    @Column(name = "return_order_code")
    private String returnOrderCode;

    /**
     * 获取记录id
     *
     * @return flow_id - 记录id
     */
    public Integer getFlowId() {
        return flowId;
    }

    /**
     * 设置记录id
     *
     * @param flowId 记录id
     */
    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    /**
     * 获取产品明细条形码
     *
     * @return product_det_barcode - 产品明细条形码
     */
    public String getProductDetBarcode() {
        return productDetBarcode;
    }

    /**
     * 设置产品明细条形码
     *
     * @param productDetBarcode 产品明细条形码
     */
    public void setProductDetBarcode(String productDetBarcode) {
        this.productDetBarcode = productDetBarcode;
    }

    /**
     * 获取产品条形码
     *
     * @return product_barcode - 产品条形码
     */
    public String getProductBarcode() {
        return productBarcode;
    }

    /**
     * 设置产品条形码
     *
     * @param productBarcode 产品条形码
     */
    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    /**
     * 获取产品出库单号
     *
     * @return delivery_order_code - 产品出库单号
     */
    public String getDeliveryOrderCode() {
        return deliveryOrderCode;
    }

    /**
     * 设置产品出库单号
     *
     * @param deliveryOrderCode 产品出库单号
     */
    public void setDeliveryOrderCode(String deliveryOrderCode) {
        this.deliveryOrderCode = deliveryOrderCode;
    }

    /**
     * 获取产品明细退货时间
     *
     * @return product_det_returntime - 产品明细退货时间
     */
    public Date getProductDetReturntime() {
        return productDetReturntime;
    }

    /**
     * 设置产品明细退货时间
     *
     * @param productDetReturntime 产品明细退货时间
     */
    public void setProductDetReturntime(Date productDetReturntime) {
        this.productDetReturntime = productDetReturntime;
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
     * 获取退货状态（0已出库后退货/1未出库退货）
     *
     * @return return_state - 退货状态（0已出库后退货/1未出库退货）
     */
    public Integer getReturnState() {
        return returnState;
    }

    /**
     * 设置退货状态（0已出库后退货/1未出库退货）
     *
     * @param returnState 退货状态（0已出库后退货/1未出库退货）
     */
    public void setReturnState(Integer returnState) {
        this.returnState = returnState;
    }

    /**
     * 获取(0表示入库流/1出库流水/2退货流水)
     *
     * @return flowcode_state - (0表示入库流/1出库流水/2退货流水)
     */
    public Integer getFlowcodeState() {
        return flowcodeState;
    }

    /**
     * 设置(0表示入库流/1出库流水/2退货流水)
     *
     * @param flowcodeState (0表示入库流/1出库流水/2退货流水)
     */
    public void setFlowcodeState(Integer flowcodeState) {
        this.flowcodeState = flowcodeState;
    }

    /**
     * 获取产品明细入库时间
     *
     * @return product_det_waretime - 产品明细入库时间
     */
    public Date getProductDetWaretime() {
        return productDetWaretime;
    }

    /**
     * 设置产品明细入库时间
     *
     * @param productDetWaretime 产品明细入库时间
     */
    public void setProductDetWaretime(Date productDetWaretime) {
        this.productDetWaretime = productDetWaretime;
    }

    /**
     * 获取产品明细出库时间
     *
     * @return product_det_deliverytime - 产品明细出库时间
     */
    public Date getProductDetDeliverytime() {
        return productDetDeliverytime;
    }

    /**
     * 设置产品明细出库时间
     *
     * @param productDetDeliverytime 产品明细出库时间
     */
    public void setProductDetDeliverytime(Date productDetDeliverytime) {
        this.productDetDeliverytime = productDetDeliverytime;
    }

    /**
     * 获取出货长度
     *
     * @return delivery_length - 出货长度
     */
    public Float getDeliveryLength() {
        return deliveryLength;
    }

    /**
     * 设置出货长度
     *
     * @param deliveryLength 出货长度
     */
    public void setDeliveryLength(Float deliveryLength) {
        this.deliveryLength = deliveryLength;
    }

    /**
     * 获取出库条形码
     *
     * @return delivery_barcode - 出库条形码
     */
    public String getDeliveryBarcode() {
        return deliveryBarcode;
    }

    /**
     * 设置出库条形码
     *
     * @param deliveryBarcode 出库条形码
     */
    public void setDeliveryBarcode(String deliveryBarcode) {
        this.deliveryBarcode = deliveryBarcode;
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

}
