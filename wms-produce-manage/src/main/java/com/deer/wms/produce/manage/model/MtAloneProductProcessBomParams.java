package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by  on 2019/09/28.
*/
public class MtAloneProductProcessBomParams extends QueryParams {
    private String productName;
    private String productNum;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }
}
