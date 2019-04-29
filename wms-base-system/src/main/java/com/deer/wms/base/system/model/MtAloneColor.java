package com.deer.wms.base.system.model;

import javax.persistence.*;

@Table(name = "mt_alone_color")
public class MtAloneColor {
    /**
     * 颜色id
     */
    @Id
    @Column(name = "color_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer colorId;

    /**
     * 颜色编码
     */
    @Column(name = "color_code")
    private String colorCode;

    /**
     * 颜色名称
     */
    @Column(name = "color_name")
    private String colorName;
    
    /**
     * 颜色名称(中文)
     */
    @Column(name = "color_name_ch")
    private String colorNameCh;

    /**
     * 备注
     */
    private String memo;

    /**
     * 对应公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * RGB_R值
     */
    @Column(name = "rgb_r")
    private Integer rgbR;

    /**
     * RGB_G值
     */
    @Column(name = "rgb_g")
    private Integer rgbG;

    /**
     * RGB_B值
     */
    @Column(name = "rgb_b")
    private Integer rgbB;

    /**
     * 透明度
     */
    @Column(name = "rgb_t")
    private Float rgbT;

    /**
     * 十六进制
     */
    @Column(name = "rgb_hex")
    private String rgbHex;

    /**
     * 潘通色号
     */
    @Column(name = "pantone_code")
    private String pantoneCode;

    /**
     * 获取颜色id
     *
     * @return color_id - 颜色id
     */
    public Integer getColorId() {
        return colorId;
    }

    /**
     * 设置颜色id
     *
     * @param colorId 颜色id
     */
    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    /**
     * 获取颜色编码
     *
     * @return color_code - 颜色编码
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     * 设置颜色编码
     *
     * @param colorCode 颜色编码
     */
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    /**
     * 获取颜色名称
     *
     * @return color_name - 颜色名称
     */
    public String getColorName() {
        return colorName;
    }

    /**
     * 设置颜色名称
     *
     * @param colorName 颜色名称
     */
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    /**
	 * @return the colorNameCh
	 */
	public String getColorNameCh() {
		return colorNameCh;
	}

	/**
	 * @param colorNameCh the colorNameCh to set
	 */
	public void setColorNameCh(String colorNameCh) {
		this.colorNameCh = colorNameCh;
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
     * 获取对应公司id
     *
     * @return company_id - 对应公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置对应公司id
     *
     * @param companyId 对应公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取RGB_R值
     *
     * @return rgb_r - RGB_R值
     */
    public Integer getRgbR() {
        return rgbR;
    }

    /**
     * 设置RGB_R值
     *
     * @param rgbR RGB_R值
     */
    public void setRgbR(Integer rgbR) {
        this.rgbR = rgbR;
    }

    /**
     * 获取RGB_G值
     *
     * @return rgb_g - RGB_G值
     */
    public Integer getRgbG() {
        return rgbG;
    }

    /**
     * 设置RGB_G值
     *
     * @param rgbG RGB_G值
     */
    public void setRgbG(Integer rgbG) {
        this.rgbG = rgbG;
    }

    /**
     * 获取RGB_B值
     *
     * @return rgb_b - RGB_B值
     */
    public Integer getRgbB() {
        return rgbB;
    }

    /**
     * 设置RGB_B值
     *
     * @param rgbB RGB_B值
     */
    public void setRgbB(Integer rgbB) {
        this.rgbB = rgbB;
    }

    /**
     * 获取透明度
     *
     * @return rgb_t - 透明度
     */
    public Float getRgbT() {
        return rgbT;
    }

    /**
     * 设置透明度
     *
     * @param rgbT 透明度
     */
    public void setRgbT(Float rgbT) {
        this.rgbT = rgbT;
    }

    /**
     * 获取十六进制
     *
     * @return rgb_hex - 十六进制
     */
    public String getRgbHex() {
        return rgbHex;
    }

    /**
     * 设置十六进制
     *
     * @param rgbHex 十六进制
     */
    public void setRgbHex(String rgbHex) {
        this.rgbHex = rgbHex;
    }

    /**
     * 获取潘通色号
     *
     * @return pantone_code - 潘通色号
     */
    public String getPantoneCode() {
        return pantoneCode;
    }

    /**
     * 设置潘通色号
     *
     * @param pantoneCode 潘通色号
     */
    public void setPantoneCode(String pantoneCode) {
        this.pantoneCode = pantoneCode;
    }
}