package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_process_materials_bom")
public class MtAloneProcessMaterialsBom {
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
    private Integer version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 工序bom的id，关联工序表：mt_alone_process_bom
     */
    @Column(name = "process_bom_id")
    private Integer processBomId;

    /**
     * 物料id，关联物料表：mt_alone_materials_info
     */
    @Column(name = "materials_id")
    private Integer materialsId;

    /**
     * 物料编码
     */
    private String code;

    /**
     * 规格类型
     */
    private String specification;

    /**
     * 用量
     */
    private Float dosage;

    /**
     * 单位id
     */
    @Column(name = "unit_id")
    private Integer unitId;

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
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(Integer version) {
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
     * 获取工序bom的id，关联工序表：mt_alone_process_bom
     *
     * @return process_bom_id - 工序bom的id，关联工序表：mt_alone_process_bom
     */
    public Integer getProcessBomId() {
        return processBomId;
    }

    /**
     * 设置工序bom的id，关联工序表：mt_alone_process_bom
     *
     * @param processBomId 工序bom的id，关联工序表：mt_alone_process_bom
     */
    public void setProcessBomId(Integer processBomId) {
        this.processBomId = processBomId;
    }

    /**
     * 获取物料id，关联物料表：mt_alone_materials_info
     *
     * @return materials_id - 物料id，关联物料表：mt_alone_materials_info
     */
    public Integer getMaterialsId() {
        return materialsId;
    }

    /**
     * 设置物料id，关联物料表：mt_alone_materials_info
     *
     * @param materialsId 物料id，关联物料表：mt_alone_materials_info
     */
    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    /**
     * 获取物料编码
     *
     * @return code - 物料编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置物料编码
     *
     * @param code 物料编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取规格类型
     *
     * @return specification - 规格类型
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置规格类型
     *
     * @param specification 规格类型
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取用量
     *
     * @return dosage - 用量
     */
    public Float getDosage() {
        return dosage;
    }

    /**
     * 设置用量
     *
     * @param dosage 用量
     */
    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    /**
     * 获取单位id
     *
     * @return unit_id - 单位id
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 设置单位id
     *
     * @param unitId 单位id
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
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