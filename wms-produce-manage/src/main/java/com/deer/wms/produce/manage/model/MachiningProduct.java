package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_machining_product")
public class MachiningProduct {
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
     * 版本号 默认为 1.1
     */
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 产品编码
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品类型（坯布、尾单···）
     */
    @Column(name = "product_type_code")
    private String productTypeCode;

    /**
     * 产品品种（尼龙、春亚纺···）
     */
    @Column(name = "product_variety_code")
    private String productVarietyCode;

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
     * 门幅
     */
    private Float larghezza;

    /**
     * 克重
     */
    private Float grammage;

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
     * 可以，有三个复选框，是否为原料半成品，成品（0:原材料，1：成品，2：半成品）
     */
    @Column(name = "cloth_attr")
    private Integer clothAttr;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 备注
     */
    private String note;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

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
     * 获取版本号 默认为 1.1
     *
     * @return version - 版本号 默认为 1.1
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取状态		0使用，1禁用
     *
     * @return status - 状态		0使用，1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0使用，1禁用
     *
     * @param status 状态		0使用，1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取产品编码
     *
     * @return product_code - 产品编码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置产品编码
     *
     * @param productCode 产品编码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
     * 获取产品类型（坯布、尾单···）
     *
     * @return product_type_code - 产品类型（坯布、尾单···）
     */
    public String getProductTypeCode() {
        return productTypeCode;
    }

    /**
     * 设置产品类型（坯布、尾单···）
     *
     * @param productTypeCode 产品类型（坯布、尾单···）
     */
    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    /**
     * 获取产品品种（尼龙、春亚纺···）
     *
     * @return product_variety_code - 产品品种（尼龙、春亚纺···）
     */
    public String getProductVarietyCode() {
        return productVarietyCode;
    }

    /**
     * 设置产品品种（尼龙、春亚纺···）
     *
     * @param productVarietyCode 产品品种（尼龙、春亚纺···）
     */
    public void setProductVarietyCode(String productVarietyCode) {
        this.productVarietyCode = productVarietyCode;
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
     * 获取可以，有三个复选框，是否为原料半成品，成品（0:原材料，1：成品，2：半成品）
     *
     * @return cloth_attr - 可以，有三个复选框，是否为原料半成品，成品（0:原材料，1：成品，2：半成品）
     */
    public Integer getClothAttr() {
        return clothAttr;
    }

    /**
     * 设置可以，有三个复选框，是否为原料半成品，成品（0:原材料，1：成品，2：半成品）
     *
     * @param clothAttr 可以，有三个复选框，是否为原料半成品，成品（0:原材料，1：成品，2：半成品）
     */
    public void setClothAttr(Integer clothAttr) {
        this.clothAttr = clothAttr;
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