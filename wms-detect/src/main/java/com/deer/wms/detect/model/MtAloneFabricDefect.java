package com.deer.wms.detect.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mt_alone_fabric_defect")
public class MtAloneFabricDefect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;
    
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 状态
     */
    @Column(name = "defect_type")
    private Integer defectType;

    /**
     * 瑕疵名称
     */
    @Column(name = "defect_name")
    private String defectName;

    /**
     * 英文缩写
     */
    @Column(name = "english_abb")
    private String englishAbb;

    /**
     * 瑕疵代码
     */
    @Column(name = "defect_code")
    private String defectCode;

    /**
     * 描述
     */
    private String description;

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
     * 获取添加时间
     *
     * @return addTime - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
     * 获取状态
     *
     * @return deleteStatus - 状态
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置状态
     *
     * @param deleteStatus 状态
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取瑕疵名称
     *
     * @return defect_name - 瑕疵名称
     */
    public String getDefectName() {
        return defectName;
    }

    /**
     * 设置瑕疵名称
     *
     * @param defectName 瑕疵名称
     */
    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    /**
     * 获取英文缩写
     *
     * @return english_abb - 英文缩写
     */
    public String getEnglishAbb() {
        return englishAbb;
    }

    /**
     * 设置英文缩写
     *
     * @param englishAbb 英文缩写
     */
    public void setEnglishAbb(String englishAbb) {
        this.englishAbb = englishAbb;
    }

    /**
     * 获取瑕疵代码
     *
     * @return defect_code - 瑕疵代码
     */
    public String getDefectCode() {
        return defectCode;
    }

    /**
     * 设置瑕疵代码
     *
     * @param defectCode 瑕疵代码
     */
    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取类型
     *
     * @return defectType - 类型
     */
    public Integer getDefectType() {
        return defectType;
    }

    /**
     * 设置类型
     *
     * @param defectType 类型
     */
    public void setDefectType(Integer defectType) {
        this.defectType = defectType;
    }
}