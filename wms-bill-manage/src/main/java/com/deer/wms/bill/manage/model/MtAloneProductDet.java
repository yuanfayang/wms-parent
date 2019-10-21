package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_product_det")
public class MtAloneProductDet {
    @Id
    @Column(name = "product_det_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productDetId;

    /**
     * 产品明细编号(检验单号)
     */
    @Column(name = "product_det_code")
    private String productDetCode;

    /**
     * 产品明细卷号
     */
    @Column(name = "product_det_index")
    private Integer productDetIndex;

    /**
     * 关联产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 长度(米）
     */
    @Column(name = "product_det_length")
    private Float productDetLength;

    /**
     * 剩余米数
     */
    @Column(name = "product_det_remain_length")
    private Float productDetRemainLength;

    /**
     * 分配仓位编号
     */
    @Column(name = "cell_code")
    private String cellCode;

    /**
     * 入库状态（0未上架/1已上架）
     */
    @Column(name = "product_det_state")
    private Integer productDetState;

    /**
     * 体积
     */
    @Column(name = "volume_num")
    private String volumeNum;

    /**
     * 颜色编号
     */
    @Column(name = "color_code")
    private String colorCode;

    /**
     * 缸号
     */
    @Column(name = "dyelot_num")
    private String dyelotNum;

    /**
     * 产品明细条形码
     */
    @Column(name = "product_det_barcode")
    private String productDetBarcode;

    /**
     * 绑定产品条形码
     */
    @Column(name = "warehouse_barcode")
    private String warehouseBarcode;

    /**
     * 样品条形码
     */
    @Column(name = "detection_barcode")
    private String detectionBarcode;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 备注
     */
    private String note;

    /**
     * 重量(kg)
     */
    private Float weight;

    /**
     * 瑕疵点信息,键值对表示
     */
    @Column(name = "flaw_info")
    private String flawInfo;

    /**
     * 产品等级
     */
    @Column(name = "product_level")
    private String productLevel;

    /**
     * 正品米数
     */
    @Column(name = "salable_product_length")
    private Float salableProductLength;

    /**
     * 正品码数
     */
    @Column(name = "salable_code_length")
    private Float salableCodeLength;

    /**
     * 是否已检测(0未检测/1已检测)
     */
    @Column(name = "is_detection")
    private Integer isDetection;

    /**
     * 检测员id
     */
    @Column(name = "detection_man_id")
    private Integer detectionManId;

    /**
     * 检测员姓名
     */
    @Column(name = "detection_man_name")
    private String detectionManName;

    /**
     * 检测机器名字
     */
    @Column(name = "detection_machine_name")
    private String detectionMachineName;

    /**
     * 入库时间
     */
    @Column(name = "warehouse_entry_time")
    private Date warehouseEntryTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 出库状态（0表示未出过库/1表示出过库）
     */
    @Column(name = "delivery_state")
    private Integer deliveryState;

    /**
     * 退货状态（0表示不是退货进来的/1表示是退货进来的）
     */
    @Column(name = "return_state")
    private Integer returnState;

    /**
     * 检测时间
     */
    @Column(name = "detection_time")
    private Date detectionTime;

    /**
     * 颜色名称
     */
    @Column(name = "color_name")
    private String colorName;

    /**
     * 颜色
     */
    private String colour;

    /**
     * 颜色十六进制
     */
    @Column(name = "rgb_hex")
    private String rgbHex;

    /**
     * 是否出库完成（0表示未出完/1表示出完）
     */
    @Column(name = "is_complete_out")
    private Integer isCompleteOut;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * @return product_det_id
     */
    public Integer getProductDetId() {
        return productDetId;
    }

    /**
     * @param productDetId
     */
    public void setProductDetId(Integer productDetId) {
        this.productDetId = productDetId;
    }

    /**
     * 获取产品明细编号(检验单号)
     *
     * @return product_det_code - 产品明细编号(检验单号)
     */
    public String getProductDetCode() {
        return productDetCode;
    }

    /**
     * 设置产品明细编号(检验单号)
     *
     * @param productDetCode 产品明细编号(检验单号)
     */
    public void setProductDetCode(String productDetCode) {
        this.productDetCode = productDetCode;
    }

    /**
     * 获取产品明细卷号
     *
     * @return product_det_index - 产品明细卷号
     */
    public Integer getProductDetIndex() {
        return productDetIndex;
    }

    /**
     * 设置产品明细卷号
     *
     * @param productDetIndex 产品明细卷号
     */
    public void setProductDetIndex(Integer productDetIndex) {
        this.productDetIndex = productDetIndex;
    }

    /**
     * 获取关联产品id
     *
     * @return product_id - 关联产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置关联产品id
     *
     * @param productId 关联产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取长度(米）
     *
     * @return product_det_length - 长度(米）
     */
    public Float getProductDetLength() {
        return productDetLength;
    }

    /**
     * 设置长度(米）
     *
     * @param productDetLength 长度(米）
     */
    public void setProductDetLength(Float productDetLength) {
        this.productDetLength = productDetLength;
    }

    /**
     * 获取剩余米数
     *
     * @return product_det_remain_length - 剩余米数
     */
    public Float getProductDetRemainLength() {
        return productDetRemainLength;
    }

    /**
     * 设置剩余米数
     *
     * @param productDetRemainLength 剩余米数
     */
    public void setProductDetRemainLength(Float productDetRemainLength) {
        this.productDetRemainLength = productDetRemainLength;
    }

    /**
     * 获取分配仓位编号
     *
     * @return cell_code - 分配仓位编号
     */
    public String getCellCode() {
        return cellCode;
    }

    /**
     * 设置分配仓位编号
     *
     * @param cellCode 分配仓位编号
     */
    public void setCellCode(String cellCode) {
        this.cellCode = cellCode;
    }

    /**
     * 获取入库状态（0未上架/1已上架）
     *
     * @return product_det_state - 入库状态（0未上架/1已上架）
     */
    public Integer getProductDetState() {
        return productDetState;
    }

    /**
     * 设置入库状态（0未上架/1已上架）
     *
     * @param productDetState 入库状态（0未上架/1已上架）
     */
    public void setProductDetState(Integer productDetState) {
        this.productDetState = productDetState;
    }

    /**
     * 获取体积
     *
     * @return volume_num - 体积
     */
    public String getVolumeNum() {
        return volumeNum;
    }

    /**
     * 设置体积
     *
     * @param volumeNum 体积
     */
    public void setVolumeNum(String volumeNum) {
        this.volumeNum = volumeNum;
    }

    /**
     * 获取颜色编号
     *
     * @return color_code - 颜色编号
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     * 设置颜色编号
     *
     * @param colorCode 颜色编号
     */
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    /**
     * 获取缸号
     *
     * @return dyelot_num - 缸号
     */
    public String getDyelotNum() {
        return dyelotNum;
    }

    /**
     * 设置缸号
     *
     * @param dyelotNum 缸号
     */
    public void setDyelotNum(String dyelotNum) {
        this.dyelotNum = dyelotNum;
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
     * 获取绑定产品条形码
     *
     * @return warehouse_barcode - 绑定产品条形码
     */
    public String getWarehouseBarcode() {
        return warehouseBarcode;
    }

    /**
     * 设置绑定产品条形码
     *
     * @param warehouseBarcode 绑定产品条形码
     */
    public void setWarehouseBarcode(String warehouseBarcode) {
        this.warehouseBarcode = warehouseBarcode;
    }

    /**
     * 获取样品条形码
     *
     * @return detection_barcode - 样品条形码
     */
    public String getDetectionBarcode() {
        return detectionBarcode;
    }

    /**
     * 设置样品条形码
     *
     * @param detectionBarcode 样品条形码
     */
    public void setDetectionBarcode(String detectionBarcode) {
        this.detectionBarcode = detectionBarcode;
    }

    /**
     * 获取描述信息
     *
     * @return description - 描述信息
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述信息
     *
     * @param description 描述信息
     */
    public void setDescription(String description) {
        this.description = description;
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
     * 获取重量(kg)
     *
     * @return weight - 重量(kg)
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * 设置重量(kg)
     *
     * @param weight 重量(kg)
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * 获取瑕疵点信息,键值对表示
     *
     * @return flaw_info - 瑕疵点信息,键值对表示
     */
    public String getFlawInfo() {
        return flawInfo;
    }

    /**
     * 设置瑕疵点信息,键值对表示
     *
     * @param flawInfo 瑕疵点信息,键值对表示
     */
    public void setFlawInfo(String flawInfo) {
        this.flawInfo = flawInfo;
    }

    /**
     * 获取产品等级
     *
     * @return product_level - 产品等级
     */
    public String getProductLevel() {
        return productLevel;
    }

    /**
     * 设置产品等级
     *
     * @param productLevel 产品等级
     */
    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    /**
     * 获取正品米数
     *
     * @return salable_product_length - 正品米数
     */
    public Float getSalableProductLength() {
        return salableProductLength;
    }

    /**
     * 设置正品米数
     *
     * @param salableProductLength 正品米数
     */
    public void setSalableProductLength(Float salableProductLength) {
        this.salableProductLength = salableProductLength;
    }

    /**
     * 获取正品码数
     *
     * @return salable_code_length - 正品码数
     */
    public Float getSalableCodeLength() {
        return salableCodeLength;
    }

    /**
     * 设置正品码数
     *
     * @param salableCodeLength 正品码数
     */
    public void setSalableCodeLength(Float salableCodeLength) {
        this.salableCodeLength = salableCodeLength;
    }

    /**
     * 获取是否已检测(0未检测/1已检测)
     *
     * @return is_detection - 是否已检测(0未检测/1已检测)
     */
    public Integer getIsDetection() {
        return isDetection;
    }

    /**
     * 设置是否已检测(0未检测/1已检测)
     *
     * @param isDetection 是否已检测(0未检测/1已检测)
     */
    public void setIsDetection(Integer isDetection) {
        this.isDetection = isDetection;
    }

    /**
     * 获取检测员id
     *
     * @return detection_man_id - 检测员id
     */
    public Integer getDetectionManId() {
        return detectionManId;
    }

    /**
     * 设置检测员id
     *
     * @param detectionManId 检测员id
     */
    public void setDetectionManId(Integer detectionManId) {
        this.detectionManId = detectionManId;
    }

    /**
     * 获取检测员姓名
     *
     * @return detection_man_name - 检测员姓名
     */
    public String getDetectionManName() {
        return detectionManName;
    }

    /**
     * 设置检测员姓名
     *
     * @param detectionManName 检测员姓名
     */
    public void setDetectionManName(String detectionManName) {
        this.detectionManName = detectionManName;
    }

    /**
     * 获取检测机器名字
     *
     * @return detection_machine_name - 检测机器名字
     */
    public String getDetectionMachineName() {
        return detectionMachineName;
    }

    /**
     * 设置检测机器名字
     *
     * @param detectionMachineName 检测机器名字
     */
    public void setDetectionMachineName(String detectionMachineName) {
        this.detectionMachineName = detectionMachineName;
    }

    /**
     * 获取入库时间
     *
     * @return warehouse_entry_time - 入库时间
     */
    public Date getWarehouseEntryTime() {
        return warehouseEntryTime;
    }

    /**
     * 设置入库时间
     *
     * @param warehouseEntryTime 入库时间
     */
    public void setWarehouseEntryTime(Date warehouseEntryTime) {
        this.warehouseEntryTime = warehouseEntryTime;
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
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取出库状态（0表示未出过库/1表示出过库）
     *
     * @return delivery_state - 出库状态（0表示未出过库/1表示出过库）
     */
    public Integer getDeliveryState() {
        return deliveryState;
    }

    /**
     * 设置出库状态（0表示未出过库/1表示出过库）
     *
     * @param deliveryState 出库状态（0表示未出过库/1表示出过库）
     */
    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    /**
     * 获取退货状态（0表示不是退货进来的/1表示是退货进来的）
     *
     * @return return_state - 退货状态（0表示不是退货进来的/1表示是退货进来的）
     */
    public Integer getReturnState() {
        return returnState;
    }

    /**
     * 设置退货状态（0表示不是退货进来的/1表示是退货进来的）
     *
     * @param returnState 退货状态（0表示不是退货进来的/1表示是退货进来的）
     */
    public void setReturnState(Integer returnState) {
        this.returnState = returnState;
    }

    /**
     * 获取检测时间
     *
     * @return detection_time - 检测时间
     */
    public Date getDetectionTime() {
        return detectionTime;
    }

    /**
     * 设置检测时间
     *
     * @param detectionTime 检测时间
     */
    public void setDetectionTime(Date detectionTime) {
        this.detectionTime = detectionTime;
    }

    /**
     * 获取颜色名称
     *
     * @return color_name - 颜色名称
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * 设置颜色名称
     *
     * @param colorName 颜色名称
     */
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    /**
     * 获取颜色
     *
     * @return colour - 颜色
     */
    public String getColour() {
        return colour;
    }

    /**
     * 设置颜色
     *
     * @param colour 颜色
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * 获取颜色十六进制
     *
     * @return rgb_hex - 颜色十六进制
     */
    public String getRgbHex() {
        return rgbHex;
    }

    /**
     * 设置颜色十六进制
     *
     * @param rgbHex 颜色十六进制
     */
    public void setRgbHex(String rgbHex) {
        this.rgbHex = rgbHex;
    }

    /**
     * 获取是否出库完成（0表示未出完/1表示出完）
     *
     * @return is_complete_out - 是否出库完成（0表示未出完/1表示出完）
     */
    public Integer getIsCompleteOut() {
        return isCompleteOut;
    }

    /**
     * 设置是否出库完成（0表示未出完/1表示出完）
     *
     * @param isCompleteOut 是否出库完成（0表示未出完/1表示出完）
     */
    public void setIsCompleteOut(Integer isCompleteOut) {
        this.isCompleteOut = isCompleteOut;
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
}