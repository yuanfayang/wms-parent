package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_product")
public class MtAloneProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 批次
     */
    private String batch;

    /**
     * 供应商编号
     */
    @Column(name = "supplier_code")
    private String supplierCode;

    /**
     * 品号
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 料号
     */
    @Column(name = "item_code")
    private String itemCode;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品类型
     */
    @Column(name = "product_type_code")
    private String productTypeCode;

    /**
     * 产品品种
     */
    @Column(name = "product_variety_code")
    private String productVarietyCode;

    /**
     * 颜色编号
     */
    @Column(name = "color_code")
    private String colorCode;

    /**
     * 面料
     */
    @Column(name = "shell_fabric")
    private String shellFabric;

    /**
     * 组织
     */
    private String tissue;

    /**
     * 产地
     */
    private String origin;

    /**
     * 库存数量
     */
    @Column(name = "ware_num")
    private Integer wareNum;

    /**
     * 计量单位
     */
    @Column(name = "unit_code")
    private String unitCode;

    /**
     * 供应商库存数量
     */
    @Column(name = "supplier_num")
    private Integer supplierNum;

    /**
     * 进货单价(每米/元)
     */
    private Float price;

    /**
     * 门幅
     */
    private Float larghezza;

    /**
     * 门幅单位编号
     */
    @Column(name = "larghezza_unit_code")
    private String larghezzaUnitCode;

    /**
     * 克重
     */
    private Float grammage;

    /**
     * 克重单位编号
     */
    @Column(name = "grammage_unit_code")
    private String grammageUnitCode;

    /**
     * 总米数
     */
    @Column(name = "product_length")
    private Float productLength;

    /**
     * 剩余米数
     */
    @Column(name = "product_remain_length")
    private Float productRemainLength;

    /**
     * 密度
     */
    private String density;

    /**
     * 规格
     */
    private String specification;

    /**
     * 加工方式
     */
    @Column(name = "processing_mode")
    private String processingMode;

    /**
     * 产品条形码(检测条形码）
     */
    @Column(name = "product_bar_code")
    private String productBarCode;

    /**
     * 样品条形码
     */
    @Column(name = "specimen_bar_code")
    private String specimenBarCode;

    /**
     * 登记员id
     */
    @Column(name = "greffier_id")
    private String greffierId;

    /**
     * 是否要检测（0不检测/1检测）
     */
    @Column(name = "is_detection")
    private Integer isDetection;

    /**
     * 检测员id
     */
    @Column(name = "detection_man_id")
    private String detectionManId;

    /**
     * 入库状态(0未入库/1部分入库/2全部入库)
     */
    @Column(name = "product_state")
    private Integer productState;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 备注
     */
    private String note;

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
     * 审核状态（0未通过/1通过/2待审核）
     */
    @Column(name = "reviewe_state")
    private Integer revieweState;

    /**
     * 出库状态（0未出库/1部分出库/2全部出库）
     */
    @Column(name = "delivery_state")
    private Integer deliveryState;

    /**
     * 退货状态（0没有退过货/1有退货）
     */
    @Column(name = "return_state")
    private Integer returnState;

    /**
     * 缸号
     */
    @Column(name = "dyelot_num")
    private String dyelotNum;

    /**
     * 颜色十六进制
     */
    @Column(name = "rgb_hex")
    private String rgbHex;

    /**
     * 颜色名称
     */
    @Column(name = "color_name")
    private String colorName;

    /**
     * 检测总米数
     */
    @Column(name = "product_detect_length")
    private Float productDetectLength;

    /**
     * 图片地址,用分号隔开
     */
    private String images;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 仓位
     */
    @Column(name = "cell_code")
    private String cellCode;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;
    /**
     * 采购员id
     */
    @Column(name = "purchaser_id")
    private Integer purchaserId;
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
     * 获取批次
     *
     * @return batch - 批次
     */
    public String getBatch() {
        return batch;
    }

    /**
     * 设置批次
     *
     * @param batch 批次
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * 获取供应商编号
     *
     * @return supplier_code - 供应商编号
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * 设置供应商编号
     *
     * @param supplierCode 供应商编号
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * 获取品号
     *
     * @return product_code - 品号
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置品号
     *
     * @param productCode 品号
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 获取料号
     *
     * @return item_code - 料号
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置料号
     *
     * @param itemCode 料号
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品类型
     *
     * @return product_type_code - 产品类型
     */
    public String getProductTypeCode() {
        return productTypeCode;
    }

    /**
     * 设置产品类型
     *
     * @param productTypeCode 产品类型
     */
    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    /**
     * 获取产品品种
     *
     * @return product_variety_code - 产品品种
     */
    public String getProductVarietyCode() {
        return productVarietyCode;
    }

    /**
     * 设置产品品种
     *
     * @param productVarietyCode 产品品种
     */
    public void setProductVarietyCode(String productVarietyCode) {
        this.productVarietyCode = productVarietyCode;
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
     * 获取面料
     *
     * @return shell_fabric - 面料
     */
    public String getShellFabric() {
        return shellFabric;
    }

    /**
     * 设置面料
     *
     * @param shellFabric 面料
     */
    public void setShellFabric(String shellFabric) {
        this.shellFabric = shellFabric;
    }

    /**
     * 获取组织
     *
     * @return tissue - 组织
     */
    public String getTissue() {
        return tissue;
    }

    /**
     * 设置组织
     *
     * @param tissue 组织
     */
    public void setTissue(String tissue) {
        this.tissue = tissue;
    }

    /**
     * 获取产地
     *
     * @return origin - 产地
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置产地
     *
     * @param origin 产地
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 获取库存数量
     *
     * @return ware_num - 库存数量
     */
    public Integer getWareNum() {
        return wareNum;
    }

    /**
     * 设置库存数量
     *
     * @param wareNum 库存数量
     */
    public void setWareNum(Integer wareNum) {
        this.wareNum = wareNum;
    }

    /**
     * 获取计量单位
     *
     * @return unit_code - 计量单位
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * 设置计量单位
     *
     * @param unitCode 计量单位
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * 获取供应商库存数量
     *
     * @return supplier_num - 供应商库存数量
     */
    public Integer getSupplierNum() {
        return supplierNum;
    }

    /**
     * 设置供应商库存数量
     *
     * @param supplierNum 供应商库存数量
     */
    public void setSupplierNum(Integer supplierNum) {
        this.supplierNum = supplierNum;
    }

    /**
     * 获取进货单价(每米/元)
     *
     * @return price - 进货单价(每米/元)
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置进货单价(每米/元)
     *
     * @param price 进货单价(每米/元)
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取门幅
     *
     * @return larghezza - 门幅
     */
    public Float getLarghezza() {
        return larghezza;
    }

    /**
     * 设置门幅
     *
     * @param larghezza 门幅
     */
    public void setLarghezza(Float larghezza) {
        this.larghezza = larghezza;
    }

    /**
     * 获取门幅单位编号
     *
     * @return larghezza_unit_code - 门幅单位编号
     */
    public String getLarghezzaUnitCode() {
        return larghezzaUnitCode;
    }

    /**
     * 设置门幅单位编号
     *
     * @param larghezzaUnitCode 门幅单位编号
     */
    public void setLarghezzaUnitCode(String larghezzaUnitCode) {
        this.larghezzaUnitCode = larghezzaUnitCode;
    }

    /**
     * 获取克重
     *
     * @return grammage - 克重
     */
    public Float getGrammage() {
        return grammage;
    }

    /**
     * 设置克重
     *
     * @param grammage 克重
     */
    public void setGrammage(Float grammage) {
        this.grammage = grammage;
    }

    /**
     * 获取克重单位编号
     *
     * @return grammage_unit_code - 克重单位编号
     */
    public String getGrammageUnitCode() {
        return grammageUnitCode;
    }

    /**
     * 设置克重单位编号
     *
     * @param grammageUnitCode 克重单位编号
     */
    public void setGrammageUnitCode(String grammageUnitCode) {
        this.grammageUnitCode = grammageUnitCode;
    }

    /**
     * 获取总米数
     *
     * @return product_length - 总米数
     */
    public Float getProductLength() {
        return productLength;
    }

    /**
     * 设置总米数
     *
     * @param productLength 总米数
     */
    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    /**
     * 获取剩余米数
     *
     * @return product_remain_length - 剩余米数
     */
    public Float getProductRemainLength() {
        return productRemainLength;
    }

    /**
     * 设置剩余米数
     *
     * @param productRemainLength 剩余米数
     */
    public void setProductRemainLength(Float productRemainLength) {
        this.productRemainLength = productRemainLength;
    }

    /**
     * 获取密度
     *
     * @return density - 密度
     */
    public String getDensity() {
        return density;
    }

    /**
     * 设置密度
     *
     * @param density 密度
     */
    public void setDensity(String density) {
        this.density = density;
    }

    /**
     * 获取规格
     *
     * @return specification - 规格
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置规格
     *
     * @param specification 规格
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取加工方式
     *
     * @return processing_mode - 加工方式
     */
    public String getProcessingMode() {
        return processingMode;
    }

    /**
     * 设置加工方式
     *
     * @param processingMode 加工方式
     */
    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode;
    }

    /**
     * 获取产品条形码(检测条形码）
     *
     * @return product_bar_code - 产品条形码(检测条形码）
     */
    public String getProductBarCode() {
        return productBarCode;
    }

    /**
     * 设置产品条形码(检测条形码）
     *
     * @param productBarCode 产品条形码(检测条形码）
     */
    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    /**
     * 获取样品条形码
     *
     * @return specimen_bar_code - 样品条形码
     */
    public String getSpecimenBarCode() {
        return specimenBarCode;
    }

    /**
     * 设置样品条形码
     *
     * @param specimenBarCode 样品条形码
     */
    public void setSpecimenBarCode(String specimenBarCode) {
        this.specimenBarCode = specimenBarCode;
    }

    /**
     * 获取登记员id
     *
     * @return greffier_id - 登记员id
     */
    public String getGreffierId() {
        return greffierId;
    }

    /**
     * 设置登记员id
     *
     * @param greffierId 登记员id
     */
    public void setGreffierId(String greffierId) {
        this.greffierId = greffierId;
    }

    /**
     * 获取是否要检测（0不检测/1检测）
     *
     * @return is_detection - 是否要检测（0不检测/1检测）
     */
    public Integer getIsDetection() {
        return isDetection;
    }

    /**
     * 设置是否要检测（0不检测/1检测）
     *
     * @param isDetection 是否要检测（0不检测/1检测）
     */
    public void setIsDetection(Integer isDetection) {
        this.isDetection = isDetection;
    }

    /**
     * 获取检测员id
     *
     * @return detection_man_id - 检测员id
     */
    public String getDetectionManId() {
        return detectionManId;
    }

    /**
     * 设置检测员id
     *
     * @param detectionManId 检测员id
     */
    public void setDetectionManId(String detectionManId) {
        this.detectionManId = detectionManId;
    }

    /**
     * 获取入库状态(0未入库/1部分入库/2全部入库)
     *
     * @return product_state - 入库状态(0未入库/1部分入库/2全部入库)
     */
    public Integer getProductState() {
        return productState;
    }

    /**
     * 设置入库状态(0未入库/1部分入库/2全部入库)
     *
     * @param productState 入库状态(0未入库/1部分入库/2全部入库)
     */
    public void setProductState(Integer productState) {
        this.productState = productState;
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
     * 获取出库状态（0未出库/1部分出库/2全部出库）
     *
     * @return delivery_state - 出库状态（0未出库/1部分出库/2全部出库）
     */
    public Integer getDeliveryState() {
        return deliveryState;
    }

    /**
     * 设置出库状态（0未出库/1部分出库/2全部出库）
     *
     * @param deliveryState 出库状态（0未出库/1部分出库/2全部出库）
     */
    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    /**
     * 获取退货状态（0没有退过货/1有退货）
     *
     * @return return_state - 退货状态（0没有退过货/1有退货）
     */
    public Integer getReturnState() {
        return returnState;
    }

    /**
     * 设置退货状态（0没有退过货/1有退货）
     *
     * @param returnState 退货状态（0没有退过货/1有退货）
     */
    public void setReturnState(Integer returnState) {
        this.returnState = returnState;
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
     * 获取检测总米数
     *
     * @return product_detect_length - 检测总米数
     */
    public Float getProductDetectLength() {
        return productDetectLength;
    }

    /**
     * 设置检测总米数
     *
     * @param productDetectLength 检测总米数
     */
    public void setProductDetectLength(Float productDetectLength) {
        this.productDetectLength = productDetectLength;
    }

    /**
     * 获取图片地址,用分号隔开
     *
     * @return images - 图片地址,用分号隔开
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置图片地址,用分号隔开
     *
     * @param images 图片地址,用分号隔开
     */
    public void setImages(String images) {
        this.images = images;
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
     * 获取仓位
     *
     * @return cell_code - 仓位
     */
    public String getCellCode() {
        return cellCode;
    }

    /**
     * 设置仓位
     *
     * @param cellCode 仓位
     */
    public void setCellCode(String cellCode) {
        this.cellCode = cellCode;
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
     * 获取绑定采购员id
     *
     * @return purchaser_id - 绑定采购员id
     */
    public Integer getPurchaserId() {
        return purchaserId;
    }

    /**
     * 设置绑定采购员id
     *
     * @param purchaserId 绑定采购员id
     */
    public void setPurchaserId(Integer purchaserId) {
        this.purchaserId = purchaserId;
    }
}