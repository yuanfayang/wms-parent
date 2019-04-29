package com.deer.wms.detect.model;

import java.util.Date;

import javax.persistence.Column;

public class MtAloneComProDetFabric {

	private String productName;
	private String productBarCode;
	private Float larghezza;
	private Float grammage;
	private String specification;
	private String dyelotNum;

	private String colorName;
	private Integer productDetIndex;
	private Float remainLength;
	private String productLevel;
	private String detNote;
	
    private Integer id;
    private Date addtime;
    private Integer deletestatus;
    private String productDetBarcode;
    private String position;
    private String description;
    private String fabricNote;
    private Integer fabricId;
    
    private Float detectLength;
    private String productCode;
    
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
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Integer getProductDetIndex() {
		return productDetIndex;
	}
	public void setProductDetIndex(Integer productDetIndex) {
		this.productDetIndex = productDetIndex;
	}
	public Float getRemainLength() {
		return remainLength;
	}
	public void setRemainLength(Float remainLength) {
		this.remainLength = remainLength;
	}
	public String getProductLevel() {
		return productLevel;
	}
	public void setProductLevel(String productLevel) {
		this.productLevel = productLevel;
	}
	public String getDetNote() {
		return detNote;
	}
	public void setDetNote(String detNote) {
		this.detNote = detNote;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Integer getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}
	public String getProductDetBarcode() {
		return productDetBarcode;
	}
	public void setProductDetBarcode(String productDetBarcode) {
		this.productDetBarcode = productDetBarcode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFabricNote() {
		return fabricNote;
	}
	public void setFabricNote(String fabricNote) {
		this.fabricNote = fabricNote;
	}
	public Integer getFabricId() {
		return fabricId;
	}
	public void setFabricId(Integer fabricId) {
		this.fabricId = fabricId;
	}
	public Float getDetectLength() {
		return detectLength;
	}
	public void setDetectLength(Float detectLength) {
		this.detectLength = detectLength;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
    
    

}
