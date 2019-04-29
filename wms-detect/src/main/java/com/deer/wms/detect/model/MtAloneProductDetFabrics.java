package com.deer.wms.detect.model;

import java.util.List;

public class MtAloneProductDetFabrics {
	
	private String productDetBarCode;
	private String colorName;
	private Integer productDetIndex;
	private Float remainLength;
	private String productLevel;
	private String note;   
    private Float detectLength;
	List<MtAloneExaminationDetails>mtAloneExaminationDetList;
	
	public List<MtAloneExaminationDetails> getMtAloneExaminationDetList() {
		return mtAloneExaminationDetList;
	}
	public void setMtAloneExaminationDetList(List<MtAloneExaminationDetails> mtAloneExaminationDetList) {
		this.mtAloneExaminationDetList = mtAloneExaminationDetList;
	}
	public String getProductDetBarCode() {
		return productDetBarCode;
	}
	public void setProductDetBarCode(String productDetBarCode) {
		this.productDetBarCode = productDetBarCode;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Float getDetectLength() {
		return detectLength;
	}
	public void setDetectLength(Float detectLength) {
		this.detectLength = detectLength;
	}

}
