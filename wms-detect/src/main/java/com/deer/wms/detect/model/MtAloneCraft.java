package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_craft")
public class MtAloneCraft {
    @Id
    @Column(name = "craft_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer craftId;

    private Integer pid;

    /**
     * 工艺类型
     */
    @Column(name = "craft_type")
    private String craftType;

    /**
     * 工艺单位
     */
    @Column(name = "craft_unit")
    private String craftUnit;

    /**
     * 是否启用0-否 1-是
     */
    @Column(name = "is_use")
    private Integer isUse;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 版本号 默认为1.0
     */
    private String version;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 备注
     */
    private String memo;

    /**
     * @return craft_id
     */
    public Integer getCraftId() {
        return craftId;
    }

    /**
     * @param craftId
     */
    public void setCraftId(Integer craftId) {
        this.craftId = craftId;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取工艺类型
     *
     * @return craft_type - 工艺类型
     */
    public String getCraftType() {
        return craftType;
    }

    /**
     * 设置工艺类型
     *
     * @param craftType 工艺类型
     */
    public void setCraftType(String craftType) {
        this.craftType = craftType;
    }

    /**
     * 获取工艺单位
     *
     * @return craft_unit - 工艺单位
     */
    public String getCraftUnit() {
        return craftUnit;
    }

    /**
     * 设置工艺单位
     *
     * @param craftUnit 工艺单位
     */
    public void setCraftUnit(String craftUnit) {
        this.craftUnit = craftUnit;
    }

    /**
     * 获取是否启用0-否 1-是
     *
     * @return is_use - 是否启用0-否 1-是
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置是否启用0-否 1-是
     *
     * @param isUse 是否启用0-否 1-是
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
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
     * 获取版本号 默认为1.0
     *
     * @return version - 版本号 默认为1.0
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为1.0
     *
     * @param version 版本号 默认为1.0
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取公司id
     *
     * @return company_id - 公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司id
     *
     * @param companyId 公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
}