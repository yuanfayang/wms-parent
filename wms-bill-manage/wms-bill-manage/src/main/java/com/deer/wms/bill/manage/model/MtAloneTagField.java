package com.deer.wms.bill.manage.model;

import javax.persistence.*;

@Table(name = "mt_alone_tag_field")
public class MtAloneTagField {
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
     * 绑定标签code
     */
    @Column(name = "tag_code")
    private String tagCode;

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
     * 获取绑定标签code
     *
     * @return tag_code - 绑定标签code
     */
    public String getTagCode() {
        return tagCode;
    }

    /**
     * 设置绑定标签code
     *
     * @param tagCode 绑定标签code
     */
    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
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