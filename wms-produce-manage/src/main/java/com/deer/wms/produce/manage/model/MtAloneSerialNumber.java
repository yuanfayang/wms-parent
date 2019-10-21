package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_serial_number")
public class MtAloneSerialNumber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Long creatorId;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private Long updaterId;

    /**
     * 版本号 默认为 1
     */
    private String version;

    /**
     * 状态		0处理中，1处理完成
     */
    private Integer status;

    /**
     * 绑定公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 一级大类
     */
    @Column(name = "first_large_class")
    private String firstLargeClass;

    /**
     * 品名
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 分类名称
     */
    @Column(name = "sort_name")
    private String sortName;

    /**
     * 计数器
     */
    @Column(name = "pin_counter")
    private Integer pinCounter;

    /**
     * 备注
     */
    private String note;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
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
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Long creatorId) {
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
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0处理中，1处理完成
     *
     * @param status 状态		0处理中，1处理完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取绑定公司id
     *
     * @return company_id - 绑定公司id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置绑定公司id
     *
     * @param companyId 绑定公司id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取一级大类
     *
     * @return first_large_class - 一级大类
     */
    public String getFirstLargeClass() {
        return firstLargeClass;
    }

    /**
     * 设置一级大类
     *
     * @param firstLargeClass 一级大类
     */
    public void setFirstLargeClass(String firstLargeClass) {
        this.firstLargeClass = firstLargeClass;
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
     * 获取分类名称
     *
     * @return sort_name - 分类名称
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * 设置分类名称
     *
     * @param sortName 分类名称
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * 获取计数器
     *
     * @return pin_counter - 计数器
     */
    public Integer getPinCounter() {
        return pinCounter;
    }

    /**
     * 设置计数器
     *
     * @param pinCounter 计数器
     */
    public void setPinCounter(Integer pinCounter) {
        this.pinCounter = pinCounter;
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

    @Override
    public String toString() {
        return "MtAloneSerialNumber{" +
                "id=" + id +
                ", operatorId=" + operatorId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creatorId=" + creatorId +
                ", updaterId=" + updaterId +
                ", version='" + version + '\'' +
                ", status=" + status +
                ", companyId=" + companyId +
                ", firstLargeClass='" + firstLargeClass + '\'' +
                ", productName='" + productName + '\'' +
                ", sortName='" + sortName + '\'' +
                ", pinCounter=" + pinCounter +
                ", note='" + note + '\'' +
                '}';
    }
}