package com.deer.wms.bill.manage.model;

public class QueryParamsDet {

    /**
     * 页码
     */
    private Integer pageNumber =1;

    /**
     * 每页显示的条数
     */
    private Integer pageSizes =199999;

    /**
     * 关键字
     */
    private String keywords = "";

    /**
     * 关联公司id
     */
    private Integer companyId = -999;

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


    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(Integer pageSizes) {
        this.pageSizes = pageSizes;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
