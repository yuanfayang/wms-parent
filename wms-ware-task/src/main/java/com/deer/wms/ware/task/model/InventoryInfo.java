package com.deer.wms.ware.task.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_inventory_info")
public class InventoryInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 盘点单号 PD-年月日时分秒-001
     */
    @Column(name = "inventory_code")
    private String inventoryCode;

    /**
     * 仓库ID, 关联表：mt_alone_ware_info
     */
    @Column(name = "ware_id")
    private Long wareId;

    /**
     * 仓库名称
     */
    @Column(name = "ware_name")
    private String wareName;

    /**
     * 盘点数量
     */
    @Column(name = "inventory_num")
    private Integer inventoryNum;

    /**
     * 真实数量
     */
    @Column(name = "real_num")
    private Integer realNum;

    /**
     * 操作员id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 添加时间， 作为盘点时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Long updaterId;

    /**
     * 版本号 默认为 1
     */
    private Integer version;

    /**
     * 状态		1处理中，2处理完成
     */
    @Column(name = "inventory_status")
    private Integer inventoryStatus;

    /**
     * 公司表
     */
    @Column(name = "company_id")
    private Integer companyId;

    private String state;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取盘点单号 PD-年月日时分秒-001
     *
     * @return inventory_code - 盘点单号 PD-年月日时分秒-001
     */
    public String getInventoryCode() {
        return inventoryCode;
    }

    /**
     * 设置盘点单号 PD-年月日时分秒-001
     *
     * @param inventoryCode 盘点单号 PD-年月日时分秒-001
     */
    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    /**
     * 获取仓库ID, 关联表：mt_alone_ware_info
     *
     * @return ware_id - 仓库ID, 关联表：mt_alone_ware_info
     */
    public Long getWareId() {
        return wareId;
    }

    /**
     * 设置仓库ID, 关联表：mt_alone_ware_info
     *
     * @param wareId 仓库ID, 关联表：mt_alone_ware_info
     */
    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    /**
     * 获取仓库名称
     *
     * @return ware_name - 仓库名称
     */
    public String getWareName() {
        return wareName;
    }

    /**
     * 设置仓库名称
     *
     * @param wareName 仓库名称
     */
    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    /**
     * 获取盘点数量
     *
     * @return inventory_num - 盘点数量
     */
    public Integer getInventoryNum() {
        return inventoryNum;
    }

    /**
     * 设置盘点数量
     *
     * @param inventoryNum 盘点数量
     */
    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    /**
     * 获取真实数量
     *
     * @return real_num - 真实数量
     */
    public Integer getRealNum() {
        return realNum;
    }

    /**
     * 设置真实数量
     *
     * @param realNum 真实数量
     */
    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
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
     * 获取添加时间， 作为盘点时间
     *
     * @return create_time - 添加时间， 作为盘点时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间， 作为盘点时间
     *
     * @param createTime 添加时间， 作为盘点时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
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
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 获取版本号 默认为 1
     *
     * @return version - 版本号 默认为 1
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1
     *
     * @param version 版本号 默认为 1
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取状态		1处理中，2处理完成
     *
     * @return inventory_status - 状态		1处理中，2处理完成
     */
    public Integer getInventoryStatus() {
        return inventoryStatus;
    }

    /**
     * 设置状态		1处理中，2处理完成
     *
     * @param inventoryStatus 状态		1处理中，2处理完成
     */
    public void setInventoryStatus(Integer inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    /**
     * 获取公司表
     *
     * @return company_id - 公司表
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司表
     *
     * @param companyId 公司表
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}