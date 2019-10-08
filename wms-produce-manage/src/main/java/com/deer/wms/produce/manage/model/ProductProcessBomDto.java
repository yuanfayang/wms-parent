package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/25 13:00
 * @Version 1.0
 */
public class ProductProcessBomDto extends ProductProcessBom{
    private String productName;//产品表里的产品名称

    private String companyName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
