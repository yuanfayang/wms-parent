package com.deer.wms.base.system.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "area_info")
public class AreaInfo {
    /**
     * 货区ID
     */
    @Id
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 仓库编码
     */
    @Column(name = "ware_code")
    private String wareCode;

    /**
     * 货区编码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 货区名
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private String addTime;

    /**
     * 备注
     */
    private String memo;

    @Column(name = "priority_level")
    private Integer priorityLevel;

    /**
     * ABC分类法
     */
    @Column(name = "abc_class")
    private String abcClass;

    /**
     * 货区类型
     */
    @Column(name = "area_type")
    private String areaType;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 获取货区ID
     *
     * @return area_id - 货区ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置货区ID
     *
     * @param areaId 货区ID
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取仓库编码
     *
     * @return ware_code - 仓库编码
     */
    public String getWareCode() {
        return wareCode;
    }

    /**
     * 设置仓库编码
     *
     * @param wareCode 仓库编码
     */
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    /**
     * 获取货区编码
     *
     * @return area_code - 货区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置货区编码
     *
     * @param areaCode 货区编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取货区名
     *
     * @return area_name - 货区名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置货区名
     *
     * @param areaName 货区名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
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
     * @return priority_level
     */
    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @param priorityLevel
     */
    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * 获取ABC分类法
     *
     * @return abc_class - ABC分类法
     */
    public String getAbcClass() {
        return abcClass;
    }

    /**
     * 设置ABC分类法
     *
     * @param abcClass ABC分类法
     */
    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }

    /**
     * 获取货区类型
     *
     * @return area_type - 货区类型
     */
    public String getAreaType() {
        return areaType;
    }

    /**
     * 设置货区类型
     *
     * @param areaType 货区类型
     */
    public void setAreaType(String areaType) {
        this.areaType = areaType;
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
}