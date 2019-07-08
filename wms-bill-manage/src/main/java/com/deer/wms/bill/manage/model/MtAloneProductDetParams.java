package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

public class MtAloneProductDetParams extends QueryParams{
	/**
     * 产品id
     */
    private Integer productId;
    /**
     * 明细类型，0-入库，1-出库
     */
    private Integer productDetType=0;

    private String productBarCode;

	public String getProductBarCode() {
		return productBarCode;
	}

	private Integer startRow=0;

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public void setProductBarCode(String productBarCode) {
		this.productBarCode = productBarCode;
	}

	public Integer getProductDetType() {
		return productDetType;
	}

	public void setProductDetType(Integer productDetType) {
		this.productDetType = productDetType;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
    
}
