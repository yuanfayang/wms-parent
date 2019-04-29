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
    @Column(name = "addTime")
    private Date addtime;
    
    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态
     */
    @Column(name = "deleteStatus")
    private Integer deletestatus;

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
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置添加时间
     *
     * @param addtime 添加时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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
    public Integer getDeletestatus() {
        return deletestatus;
    }

    /**
     * 设置状态
     *
     * @param deletestatus 状态
     */
    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
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
}