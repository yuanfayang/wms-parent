package com.deer.wms.bill.manage.model;

import java.util.Date;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/11/24.
*/
public class MtAloneProductCriteria extends QueryCriteria {
	
    private String keyWord;
    private String begDate;
    private String endDate;
    //是要查询入库状态还是审核状态下的产品，0表示入库状态，1表示审核状态
    private Integer isWareOrRevieweState;
    //0[0未入库/1部分入库/全部入库]  1[0未审核/1审核通过/2待审核]
    private Integer currentState;
    
    private String productBarCode;    
    private String productTypeCode;    //产品类型
    
    private String cellCode;
    
    

	public String getCellCode() {
		return cellCode;
	}
	public void setCellCode(String cellCode) {
		this.cellCode = cellCode;
	}
	public String getProductBarCode() {
		return productBarCode;
	}
	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
	public Integer getIsWareOrRevieweState() {
		return isWareOrRevieweState;
	}
	public void setIsWareOrRevieweState(Integer isWareOrRevieweState) {
		this.isWareOrRevieweState = isWareOrRevieweState;
	}
	public Integer getCurrentState() {
		return currentState;
	}
	public void setCurrentState(Integer currentState) {
		this.currentState = currentState;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getBegDate() {
		return begDate;
	}
	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getProductTypeCode() {
		return productTypeCode;
	}
	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}
    
}
