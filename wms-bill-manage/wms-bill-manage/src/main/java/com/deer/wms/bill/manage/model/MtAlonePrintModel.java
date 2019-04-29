package com.deer.wms.bill.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_print_model")
public class MtAlonePrintModel {
    /**
     * 主键id
     */
    @Id
    @Column(name = "print_model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer printModelId;

    /**
     * 打印模版code
     */
    @Column(name = "print_model_code")
    private String printModelCode;

    /**
     * 模版类型 0-产品 1-样品 2-入库 3-
     */
    @Column(name = "print_model_type")
    private Integer printModelType;

    /**
     * 是否是默认模版1-是 0-否
     */
    @Column(name = "is_default")
    private Byte isDefault;

    /**
     * 是否要预览 1-是 0-否
     */
    @Column(name = "is_preview")
    private Byte isPreview;

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
     * 状态  delete-删除 normal-正常
     */
    private String state;

    /**
     * 关联公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 模版内容
     */
    @Column(name = "print_model_content")
    private String printModelContent;

    /**
     * 获取主键id
     *
     * @return print_model_id - 主键id
     */
    public Integer getPrintModelId() {
        return printModelId;
    }

    /**
     * 设置主键id
     *
     * @param printModelId 主键id
     */
    public void setPrintModelId(Integer printModelId) {
        this.printModelId = printModelId;
    }

    /**
     * 获取打印模版code
     *
     * @return print_model_code - 打印模版code
     */
    public String getPrintModelCode() {
        return printModelCode;
    }

    /**
     * 设置打印模版code
     *
     * @param printModelCode 打印模版code
     */
    public void setPrintModelCode(String printModelCode) {
        this.printModelCode = printModelCode;
    }

    /**
     * 获取模版类型 0-产品 1-样品 2-入库 3-
     *
     * @return print_model_type - 模版类型 0-产品 1-样品 2-入库 3-
     */
    public Integer getPrintModelType() {
        return printModelType;
    }

    /**
     * 设置模版类型 0-产品 1-样品 2-入库 3-
     *
     * @param printModelType 模版类型 0-产品 1-样品 2-入库 3-
     */
    public void setPrintModelType(Integer printModelType) {
        this.printModelType = printModelType;
    }

    /**
     * 获取是否是默认模版1-是 0-否
     *
     * @return is_default - 是否是默认模版1-是 0-否
     */
    public Byte getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否是默认模版1-是 0-否
     *
     * @param isDefault 是否是默认模版1-是 0-否
     */
    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取是否要预览 1-是 0-否
     *
     * @return is_preview - 是否要预览 1-是 0-否
     */
    public Byte getIsPreview() {
        return isPreview;
    }

    /**
     * 设置是否要预览 1-是 0-否
     *
     * @param isPreview 是否要预览 1-是 0-否
     */
    public void setIsPreview(Byte isPreview) {
        this.isPreview = isPreview;
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
     * 获取状态  delete-删除 normal-正常
     *
     * @return state - 状态  delete-删除 normal-正常
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态  delete-删除 normal-正常
     *
     * @param state 状态  delete-删除 normal-正常
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取关联公司id
     *
     * @return company_id - 关联公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置关联公司id
     *
     * @param companyId 关联公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取模版内容
     *
     * @return print_model_content - 模版内容
     */
    public String getPrintModelContent() {
        return printModelContent;
    }

    /**
     * 设置模版内容
     *
     * @param printModelContent 模版内容
     */
    public void setPrintModelContent(String printModelContent) {
        this.printModelContent = printModelContent;
    }
}