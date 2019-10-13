package com.deer.wms.produce.manage.model;

/**
 * 有对应产品bom的产品信息对象类型，包括产品bom的id和加工总名称
 * @Author: hy
 * @Date: 2019/10/13 15:18
 * @Version 1.0
 */
public class MachiningProductHaveBom extends MachiningProduct {

    private Integer productProcessId;

    private String productProcessName;

    public Integer getProductProcessId() {
        return productProcessId;
    }

    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    public String getProductProcessName() {
        return productProcessName;
    }

    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }
}
