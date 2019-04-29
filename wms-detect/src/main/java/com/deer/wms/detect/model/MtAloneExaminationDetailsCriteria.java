package com.deer.wms.detect.model;

import java.util.List;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by guo on 2018/12/18.
*/
public class MtAloneExaminationDetailsCriteria {
    /**
     * 页码
     */
    private Integer pageNum =1;

    /**
     * 每页显示的条数
     */
    private Integer pageSize =199999;
    
    private String productDetBarcode;
    private String productBarCode;
    
    private List<String> productBarCodeList;

    public List<String> getProductBarCodeList() {
		return productBarCodeList;
	}

	public void setProductBarCodeList(List<String> productBarCodeList) {
		this.productBarCodeList = productBarCodeList;
	}

	public String getProductDetBarcode() {
		return productDetBarcode;
	}

	public void setProductDetBarcode(String productDetBarcode) {
		this.productDetBarcode = productDetBarcode;
	}

	public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public String getProductBarCode() {
		return productBarCode;
	}

	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}
    
    

}
