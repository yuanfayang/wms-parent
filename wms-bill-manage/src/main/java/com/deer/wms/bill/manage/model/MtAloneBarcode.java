package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_barcode")
public class MtAloneBarcode {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 条形码
     */
    private String barcode;

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
     * 创建人id
     */
    @Column(name = "create_man_id")
    private Integer createManId;

    /**
     * 备注
     */
    private String notes;

    /**
     * 状态 delete-删除 normal-正常
     */
    private String state;

    /**
     * 版本号
     */
    private String version;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取条形码
     *
     * @return barcode - 条形码
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * 设置条形码
     *
     * @param barcode 条形码
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
     * 获取创建人id
     *
     * @return create_man_id - 创建人id
     */
    public Integer getCreateManId() {
        return createManId;
    }

    /**
     * 设置创建人id
     *
     * @param createManId 创建人id
     */
    public void setCreateManId(Integer createManId) {
        this.createManId = createManId;
    }

    /**
     * 获取备注
     *
     * @return notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes;
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
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }
}