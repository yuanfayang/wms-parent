package com.deer.wms.detect.model;

import java.util.List;

public class MtAloneProductFabrics {
    /**
     * 产品颜色
     */
	private String colorName;
    /**
     * 产品品号
     */
	private String productCode;
    /**
     * 产品名称
     */
	private String productName;
	 /**
     * 产品条形码
     */
	private String productBarCode;
	 /**
     * 门幅
     */
	private Float larghezza;
	 /**
     * 克重
     */
	private Float grammage;
	 /**
     * 规格
     */
	private String specification;
	 /**
     * 缸号
     */
	private String dyelotNum;
	 /**
     * 明细数组
     */
	List<MtAloneProductDetFabrics>mtAloneProductDetFabricList;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	public Float getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(Float larghezza) {
		this.larghezza = larghezza;
	}
	public Float getGrammage() {
		return grammage;
	}
	public void setGrammage(Float grammage) {
		this.grammage = grammage;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getDyelotNum() {
		return dyelotNum;
	}
	public void setDyelotNum(String dyelotNum) {
		this.dyelotNum = dyelotNum;
	}
	public List<MtAloneProductDetFabrics> getMtAloneProductDetFabricList() {
		return mtAloneProductDetFabricList;
	}
	public void setMtAloneProductDetFabricList(List<MtAloneProductDetFabrics> mtAloneProductDetFabricList) {
		this.mtAloneProductDetFabricList = mtAloneProductDetFabricList;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	

}
