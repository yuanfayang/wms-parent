package com.deer.wms.ware.task.model;

import javax.persistence.*;

@Table(name = "item_type")
public class ItemType {
    /**
     * 物料类型ID
     */
    @Id
    @Column(name = "item_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemTypeId;

    /**
     * 物料类型编码
     */
    @Column(name = "item_type_code")
    private String itemTypeCode;

    /**
     * 物料类型名称
     */
    @Column(name = "item_type_name")
    private String itemTypeName;

    /**
     * 物料类型状态
     */
    @Column(name = "item_type_state")
    private Integer itemTypeState;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 获取物料类型ID
     *
     * @return item_type_id - 物料类型ID
     */
    public Integer getItemTypeId() {
        return itemTypeId;
    }

    /**
     * 设置物料类型ID
     *
     * @param itemTypeId 物料类型ID
     */
    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    /**
     * 获取物料类型编码
     *
     * @return item_type_code - 物料类型编码
     */
    public String getItemTypeCode() {
        return itemTypeCode;
    }

    /**
     * 设置物料类型编码
     *
     * @param itemTypeCode 物料类型编码
     */
    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    /**
     * 获取物料类型名称
     *
     * @return item_type_name - 物料类型名称
     */
    public String getItemTypeName() {
        return itemTypeName;
    }

    /**
     * 设置物料类型名称
     *
     * @param itemTypeName 物料类型名称
     */
    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    /**
     * 获取物料类型状态
     *
     * @return item_type_state - 物料类型状态
     */
    public Integer getItemTypeState() {
        return itemTypeState;
    }

    /**
     * 设置物料类型状态
     *
     * @param itemTypeState 物料类型状态
     */
    public void setItemTypeState(Integer itemTypeState) {
        this.itemTypeState = itemTypeState;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
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