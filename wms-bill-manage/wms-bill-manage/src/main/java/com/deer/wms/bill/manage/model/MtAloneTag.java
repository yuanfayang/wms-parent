package com.deer.wms.bill.manage.model;

import javax.persistence.*;

@Table(name = "mt_alone_tag")
public class MtAloneTag {
    /**
     * 标签id
     */
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    /**
     * 标签编码
     */
    @Id
    @Column(name = "tag_code")
    private String tagCode;

    /**
     * 标签名称
     */
    @Column(name = "tag_name")
    private String tagName;

    /**
     * 标签类型
     */
    @Column(name = "tag_type")
    private Integer tagType;

    /**
     * 是否默认标签
     */
    @Column(name = "is_default")
    private Integer isDefault;

    /**
     * 获取标签id
     *
     * @return tag_id - 标签id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 设置标签id
     *
     * @param tagId 标签id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 获取标签编码
     *
     * @return tag_code - 标签编码
     */
    public String getTagCode() {
        return tagCode;
    }

    /**
     * 设置标签编码
     *
     * @param tagCode 标签编码
     */
    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    /**
     * 获取标签名称
     *
     * @return tag_name - 标签名称
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置标签名称
     *
     * @param tagName 标签名称
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 获取标签类型
     *
     * @return tag_type - 标签类型
     */
    public Integer getTagType() {
        return tagType;
    }

    /**
     * 设置标签类型
     *
     * @param tagType 标签类型
     */
    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    /**
     * 获取是否默认标签
     *
     * @return is_default - 是否默认标签
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认标签
     *
     * @param isDefault 是否默认标签
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}