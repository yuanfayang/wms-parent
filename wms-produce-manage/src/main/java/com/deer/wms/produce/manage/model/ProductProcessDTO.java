package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/9/5 21:22
 * @Version 1.0
 *
 * 新建生产计划页面对应的结构，集成生产计划表、生产产品表等信息
 *
 */

public class ProductProcessDTO extends ProductProcess {
    private String productBarCode;//产品条形码

    private String productName;//产品名称

    private String unitName;//单位名称

    private String clientName;//客户名称

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
