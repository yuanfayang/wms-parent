package com.deer.wms.bill.manage.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_examination_details")
public class MtAloneExaminationDetails {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 添加时间
     */
    @Column(name = "addTime")
    private Date addtime;

    /**
     * 状态（0可用/1不可用）
     */
    @Column(name = "deleteStatus")
    private Integer deletestatus;

    /**
     * 明细条形码
     */
    @ApiModelProperty(value="明细条形码",name="product_det_barcode",required=true)
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 产品条形码
     */
    @ApiModelProperty(value="产品条形码",name="warehouseBarcode",required=true)
    @Column(name = "warehouse_barcode")
    private String warehouseBarcode;

    /**
     * 瑕疵点位置
     */
    @ApiModelProperty(value="瑕疵点位置",name="position")
    private String position;

    /**
     * 描述信息
     */
    @ApiModelProperty(value="描述信息",name="descriptions")
    private String descriptions;

    /**
     * 备注
     */
    private String note;

    /**
     * 绑定瑕疵基础表ID
     */
    @ApiModelProperty(value="绑定瑕疵基础表ID",name="fabric_id")
    @Column(name = "fabric_id")
    private Integer fabricId;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取添加时间
     *
     * @return addTime - 添加时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置添加时间
     *
     * @param addtime 添加时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取状态（0可用/1不可用）
     *
     * @return deleteStatus - 状态（0可用/1不可用）
     */
    public Integer getDeletestatus() {
        return deletestatus;
    }

    /**
     * 设置状态（0可用/1不可用）
     *
     * @param deletestatus 状态（0可用/1不可用）
     */
    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
    }

    /**
     * 获取明细条形码
     *
     * @return product_det_barcode - 明细条形码
     */
    public String getProductDetBarcode() {
        return productDetBarcode;
    }

    /**
     * 设置明细条形码
     *
     * @param productDetBarcode 明细条形码
     */
    public void setProductDetBarcode(String productDetBarcode) {
        this.productDetBarcode = productDetBarcode;
    }

    /**
     * 获取产品条形码
     *
     * @return warehouse_barcode - 产品条形码
     */
    public String getWarehouseBarcode() {
        return warehouseBarcode;
    }

    /**
     * 设置产品条形码
     *
     * @param warehouseBarcode 产品条形码
     */
    public void setWarehouseBarcode(String warehouseBarcode) {
        this.warehouseBarcode = warehouseBarcode;
    }

    /**
     * 获取瑕疵点位置
     *
     * @return position - 瑕疵点位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置瑕疵点位置
     *
     * @param position 瑕疵点位置
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取描述信息
     *
     * @return descriptions - 描述信息
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * 设置描述信息
     *
     * @param descriptions 描述信息
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取绑定瑕疵基础表ID
     *
     * @return fabric_id - 绑定瑕疵基础表ID
     */
    public Integer getFabricId() {
        return fabricId;
    }

    /**
     * 设置绑定瑕疵基础表ID
     *
     * @param fabricId 绑定瑕疵基础表ID
     */
    public void setFabricId(Integer fabricId) {
        this.fabricId = fabricId;
    }
}