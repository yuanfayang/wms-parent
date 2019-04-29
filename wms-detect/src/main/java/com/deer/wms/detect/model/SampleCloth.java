package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_sample_cloth")
public class SampleCloth {
    /**
     * 样布id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

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
     * 样布名称
     */
    @Column(name = "sample_name")
    private String sampleName;

    /**
     * 产品类型
     */
    @Column(name = "product_type_code")
    private String productTypeCode;

    /**
     * 产品类型id
     */
    @Column(name = "product_type_id")
    private Integer productTypeId;

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
     * 单价(每米/元)
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
     * 是否通过检测（0不检测/1检测）
     */
    @Column(name = "is_detection")
    private Integer isDetection;

    /**
     * 描述信息
     */
    private String description;

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

    @Column(name = "annex_code")
    private String annexCode;

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
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;

    /**
     * 备注
     */
    private String note;
    
    /**
     * 图片
     */
    private String images;

    /**
     * 获取样布id
     *
     * @return id - 样布id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置样布id
     *
     * @param id 样布id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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
     * 获取样布名称
     *
     * @return sample_name - 样布名称
     */
    public String getSampleName() {
        return sampleName;
    }

    /**
     * 设置样布名称
     *
     * @param sampleName 样布名称
     */
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
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
     * 获取产品类型id
     *
     * @return product_type_id - 产品类型id
     */
    public Integer getProductTypeId() {
        return productTypeId;
    }

    /**
     * 设置产品类型id
     *
     * @param productTypeId 产品类型id
     */
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
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
     * 获取单价(每米/元)
     *
     * @return price - 单价(每米/元)
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置单价(每米/元)
     *
     * @param price 单价(每米/元)
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
     * 获取是否通过检测（0不检测/1检测）
     *
     * @return is_detection - 是否通过检测（0不检测/1检测）
     */
    public Integer getIsDetection() {
        return isDetection;
    }

    /**
     * 设置是否通过检测（0不检测/1检测）
     *
     * @param isDetection 是否通过检测（0不检测/1检测）
     */
    public void setIsDetection(Integer isDetection) {
        this.isDetection = isDetection;
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
     * @return annex_code
     */
    public String getAnnexCode() {
        return annexCode;
    }

    /**
     * @param annexCode
     */
    public void setAnnexCode(String annexCode) {
        this.annexCode = annexCode;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}