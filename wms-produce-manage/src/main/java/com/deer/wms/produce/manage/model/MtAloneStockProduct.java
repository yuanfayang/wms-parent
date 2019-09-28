package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_stock_product")
public class MtAloneStockProduct {
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
    private String status;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 供应商id
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 供应商代号（关联supplier_manage）
     */
    @Column(name = "supplier_codename")
    private String supplierCodename;

    /**
     * 供应商名称
     */
    @Column(name = "supplier_name")
    private String supplierName;

    /**
     * 供应商联系人电话
     */
    @Column(name = "supplier_phone")
    private String supplierPhone;

    /**
     * 供应商联系人
     */
    @Column(name = "supplier_contacts")
    private String supplierContacts;

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
     * 品名
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 中文品名
     */
    @Column(name = "product_cha_name")
    private String productChaName;

    /**
     * 产品类型id（坯布、尾单···）（关联item_type）
     */
    @Column(name = "product_type_id")
    private Integer productTypeId;

    /**
     * 产品品种id（尼龙、春亚纺···）（关联item_type）
     */
    @Column(name = "product_variety_id")
    private Integer productVarietyId;

    /**
     * 颜色
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
     * 库存数量
     */
    @Column(name = "ware_num")
    private String wareNum;

    /**
     * 计量单位
     */
    @Column(name = "unit_code")
    private String unitCode;

    /**
     * 供应商库存数量
     */
    @Column(name = "supplier_num")
    private String supplierNum;

    /**
     * 进货单价(每米/元)
     */
    private String price;

    /**
     * 销售单价(每米/元)
     */
    @Column(name = "sales_price")
    private String salesPrice;

    /**
     * 门幅
     */
    private String larghezza;

    /**
     * 克重
     */
    private String grammage;

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
     * 开发人
     */
    private String developer;

    /**
     * 采购员id，关联用户表
     */
    @Column(name = "purchaser_id")
    private Integer purchaserId;

    /**
     * 采购员名字
     */
    @Column(name = "purchaser_name")
    private String purchaserName;

    /**
     * 销售员id，关联用户表
     */
    @Column(name = "seller_id")
    private Integer sellerId;

    /**
     * 销售员名字
     */
    @Column(name = "seller_name")
    private String sellerName;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

    /**
     * 一阶大类
     */
    private String firstLargeClass;

    /**
     * 原料
     */
    private String stockProduct;

    /**
     * 分类
     */
    private String sort;

    /**
     * 厂商库存
     */
    private String factureInventory;

    /**
     * 市场报价
     */
    private String marketPrice;

    /**
     * 优势等级
     */
    private String dominant;

    /**
     * 材料成本价
     */
    private String costPrice;

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
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态		0处理中，1处理完成
     *
     * @param status 状态		0处理中，1处理完成
     */
    public void setStatus(String status) {
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
     * 获取供应商id
     *
     * @return supplier_id - 供应商id
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商id
     *
     * @param supplierId 供应商id
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 获取供应商代号（关联supplier_manage）
     *
     * @return supplier_codename - 供应商代号（关联supplier_manage）
     */
    public String getSupplierCodename() {
        return supplierCodename;
    }

    /**
     * 设置供应商代号（关联supplier_manage）
     *
     * @param supplierCodename 供应商代号（关联supplier_manage）
     */
    public void setSupplierCodename(String supplierCodename) {
        this.supplierCodename = supplierCodename;
    }

    /**
     * 获取供应商名称
     *
     * @return supplier_name - 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 设置供应商名称
     *
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * 获取供应商联系人电话
     *
     * @return supplier_phone - 供应商联系人电话
     */
    public String getSupplierPhone() {
        return supplierPhone;
    }

    /**
     * 设置供应商联系人电话
     *
     * @param supplierPhone 供应商联系人电话
     */
    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    /**
     * 获取供应商联系人
     *
     * @return supplier_contacts - 供应商联系人
     */
    public String getSupplierContacts() {
        return supplierContacts;
    }

    /**
     * 设置供应商联系人
     *
     * @param supplierContacts 供应商联系人
     */
    public void setSupplierContacts(String supplierContacts) {
        this.supplierContacts = supplierContacts;
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
     * 获取品名
     *
     * @return product_name - 品名
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置品名
     *
     * @param productName 品名
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取中文品名
     *
     * @return product_cha_name - 中文品名
     */
    public String getProductChaName() {
        return productChaName;
    }

    /**
     * 设置中文品名
     *
     * @param productChaName 中文品名
     */
    public void setProductChaName(String productChaName) {
        this.productChaName = productChaName;
    }

    /**
     * 获取产品类型id（坯布、尾单···）（关联item_type）
     *
     * @return product_type_id - 产品类型id（坯布、尾单···）（关联item_type）
     */
    public Integer getProductTypeId() {
        return productTypeId;
    }

    /**
     * 设置产品类型id（坯布、尾单···）（关联item_type）
     *
     * @param productTypeId 产品类型id（坯布、尾单···）（关联item_type）
     */
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * 获取产品品种id（尼龙、春亚纺···）（关联item_type）
     *
     * @return product_variety_id - 产品品种id（尼龙、春亚纺···）（关联item_type）
     */
    public Integer getProductVarietyId() {
        return productVarietyId;
    }

    /**
     * 设置产品品种id（尼龙、春亚纺···）（关联item_type）
     *
     * @param productVarietyId 产品品种id（尼龙、春亚纺···）（关联item_type）
     */
    public void setProductVarietyId(Integer productVarietyId) {
        this.productVarietyId = productVarietyId;
    }

    /**
     * 获取颜色
     *
     * @return color_code - 颜色
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     * 设置颜色
     *
     * @param colorCode 颜色
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
     * 获取库存数量
     *
     * @return ware_num - 库存数量
     */
    public String getWareNum() {
        return wareNum;
    }

    /**
     * 设置库存数量
     *
     * @param wareNum 库存数量
     */
    public void setWareNum(String wareNum) {
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
    public String getSupplierNum() {
        return supplierNum;
    }

    /**
     * 设置供应商库存数量
     *
     * @param supplierNum 供应商库存数量
     */
    public void setSupplierNum(String supplierNum) {
        this.supplierNum = supplierNum;
    }

    /**
     * 获取进货单价(每米/元)
     *
     * @return price - 进货单价(每米/元)
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置进货单价(每米/元)
     *
     * @param price 进货单价(每米/元)
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取销售单价(每米/元)
     *
     * @return sales_price - 销售单价(每米/元)
     */
    public String getSalesPrice() {
        return salesPrice;
    }

    /**
     * 设置销售单价(每米/元)
     *
     * @param salesPrice 销售单价(每米/元)
     */
    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * 获取门幅
     *
     * @return larghezza - 门幅
     */
    public String getLarghezza() {
        return larghezza;
    }

    /**
     * 设置门幅
     *
     * @param larghezza 门幅
     */
    public void setLarghezza(String larghezza) {
        this.larghezza = larghezza;
    }

    /**
     * 获取克重
     *
     * @return grammage - 克重
     */
    public String getGrammage() {
        return grammage;
    }

    /**
     * 设置克重
     *
     * @param grammage 克重
     */
    public void setGrammage(String grammage) {
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
     * 获取开发人
     *
     * @return developer - 开发人
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * 设置开发人
     *
     * @param developer 开发人
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     * 获取采购员id，关联用户表
     *
     * @return purchaser_id - 采购员id，关联用户表
     */
    public Integer getPurchaserId() {
        return purchaserId;
    }

    /**
     * 设置采购员id，关联用户表
     *
     * @param purchaserId 采购员id，关联用户表
     */
    public void setPurchaserId(Integer purchaserId) {
        this.purchaserId = purchaserId;
    }

    /**
     * 获取采购员名字
     *
     * @return purchaser_name - 采购员名字
     */
    public String getPurchaserName() {
        return purchaserName;
    }

    /**
     * 设置采购员名字
     *
     * @param purchaserName 采购员名字
     */
    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    /**
     * 获取销售员id，关联用户表
     *
     * @return seller_id - 销售员id，关联用户表
     */
    public Integer getSellerId() {
        return sellerId;
    }

    /**
     * 设置销售员id，关联用户表
     *
     * @param sellerId 销售员id，关联用户表
     */
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取销售员名字
     *
     * @return seller_name - 销售员名字
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * 设置销售员名字
     *
     * @param sellerName 销售员名字
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFirstLargeClass() {
        return firstLargeClass;
    }

    public void setFirstLargeClass(String firstLargeClass) {
        this.firstLargeClass = firstLargeClass;
    }

    public String getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.stockProduct = stockProduct;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFactureInventory() {
        return factureInventory;
    }

    public void setFactureInventory(String factureInventory) {
        this.factureInventory = factureInventory;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getDominant() {
        return dominant;
    }

    public void setDominant(String dominant) {
        this.dominant = dominant;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }
}