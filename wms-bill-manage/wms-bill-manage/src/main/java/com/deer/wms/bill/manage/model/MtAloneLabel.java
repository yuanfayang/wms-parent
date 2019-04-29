package com.deer.wms.bill.manage.model;

import javax.persistence.*;

@Table(name = "mt_alone_label")
public class MtAloneLabel {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 字段列名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 字段列code
     */
    @Column(name = "column_code")
    private String columnCode;

    /**
     * 标签类型（1表示产品标签/2表示样品标签/3表示产品和明细组合标签）
     */
    @Column(name = "label_type")
    private Integer labelType;

    /**
     * 模板编号（0表示该类型的基础维护字段）
     */
    @Column(name = "mould_num")
    private Integer mouldNum;

    /**
     * 模板名称
     */
    @Column(name = "mould_name")
    private String mouldName;

    /**
     * 排序优先级
     */
    @Column(name = "column_order")
    private Integer columnOrder;

    /**
     * 占位（列）（2表示2列/4表示4列）
     */
    private Integer placeholder;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取字段列名称
     *
     * @return column_name - 字段列名称
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置字段列名称
     *
     * @param columnName 字段列名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获取字段列code
     *
     * @return column_code - 字段列code
     */
    public String getColumnCode() {
        return columnCode;
    }

    /**
     * 设置字段列code
     *
     * @param columnCode 字段列code
     */
    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    /**
     * 获取标签类型（1表示产品标签/2表示样品标签/3表示产品和明细组合标签）
     *
     * @return label_type - 标签类型（1表示产品标签/2表示样品标签/3表示产品和明细组合标签）
     */
    public Integer getLabelType() {
        return labelType;
    }

    /**
     * 设置标签类型（1表示产品标签/2表示样品标签/3表示产品和明细组合标签）
     *
     * @param labelType 标签类型（1表示产品标签/2表示样品标签/3表示产品和明细组合标签）
     */
    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }

    /**
     * 获取模板编号（0表示该类型的基础维护字段）
     *
     * @return mould_num - 模板编号（0表示该类型的基础维护字段）
     */
    public Integer getMouldNum() {
        return mouldNum;
    }

    /**
     * 设置模板编号（0表示该类型的基础维护字段）
     *
     * @param mouldNum 模板编号（0表示该类型的基础维护字段）
     */
    public void setMouldNum(Integer mouldNum) {
        this.mouldNum = mouldNum;
    }

    /**
     * 获取模板名称
     *
     * @return mould_name - 模板名称
     */
    public String getMouldName() {
        return mouldName;
    }

    /**
     * 设置模板名称
     *
     * @param mouldName 模板名称
     */
    public void setMouldName(String mouldName) {
        this.mouldName = mouldName;
    }

    /**
     * 获取排序优先级
     *
     * @return column_order - 排序优先级
     */
    public Integer getColumnOrder() {
        return columnOrder;
    }

    /**
     * 设置排序优先级
     *
     * @param columnOrder 排序优先级
     */
    public void setColumnOrder(Integer columnOrder) {
        this.columnOrder = columnOrder;
    }

    /**
     * 获取占位（列）（2表示2列/4表示4列）
     *
     * @return placeholder - 占位（列）（2表示2列/4表示4列）
     */
    public Integer getPlaceholder() {
        return placeholder;
    }

    /**
     * 设置占位（列）（2表示2列/4表示4列）
     *
     * @param placeholder 占位（列）（2表示2列/4表示4列）
     */
    public void setPlaceholder(Integer placeholder) {
        this.placeholder = placeholder;
    }
}