package com.deer.wms.bill.manage.model;


/**
 * 库存报表使用，包含产品部分信息的明细结构
 */
public class MtAloneProductDetDto extends MtAloneProductDet{
    private String supplierCode;//供应商编号
    private String supplierName;//供应商名称
    private String productCode;//品号

    private String itemCode;//料号

    private String productName;//产品名称

    private Float productLength;//产品总米数

    private String specification;//规格

    private Float price;//进货单价
    
    private String cellName;//货位名称
    private String cellAlias;//货位别名

    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSupplierCode() {
        return supplierCode;  
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductLength() {
        return productLength;
    }

    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

    public String getCellAlias() {
        return cellAlias;
    }

    public void setCellAlias(String cellAlias) {
        this.cellAlias = cellAlias;
    }
}
