package com.deer.wms.produce.manage.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "mt_alone_materials_stock_info")
public class MaterialsStockInfo {
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
     * 版本号 默认为 1.1
     */
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 物料id, 关联表：mt_alone_materials_info
     */
    @Column(name = "materials_id")
    private Integer materialsId;

    /**
     * 数量， 发起工序操作后数据可以为负数
     */
    private Float quantity;

    /**
     * 单位id, 关联单位表：unit
     */
    @Column(name = "unit_id")
    private Integer unitId;

    /**
     * 仓位名称
     */
    @Column(name = "position_name")
    private String positionName;

    /**
     * 备注
     */
    private String memo;

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
     * 获取物料id, 关联表：mt_alone_materials_info
     *
     * @return materials_id - 物料id, 关联表：mt_alone_materials_info
     */
    public Integer getMaterialsId() {
        return materialsId;
    }

    /**
     * 设置物料id, 关联表：mt_alone_materials_info
     *
     * @param materialsId 物料id, 关联表：mt_alone_materials_info
     */
    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    /**
     * 获取数量， 发起工序操作后数据可以为负数
     *
     * @return quantity - 数量， 发起工序操作后数据可以为负数
     */
    public Float getQuantity() {
        return quantity;
    }

    /**
     * 设置数量， 发起工序操作后数据可以为负数
     *
     * @param quantity 数量， 发起工序操作后数据可以为负数
     */
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取单位id, 关联单位表：unit
     *
     * @return unit_id - 单位id, 关联单位表：unit
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 设置单位id, 关联单位表：unit
     *
     * @param unitId 单位id, 关联单位表：unit
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取仓位名称
     *
     * @return position_name - 仓位名称
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * 设置仓位名称
     *
     * @param positionName 仓位名称
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
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
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}