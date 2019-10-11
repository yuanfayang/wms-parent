package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
 * 通过产品或者产品bom的id查询
* Created by hy on 2019/07/19.
*/
public class ProcessMaterialsBomParams extends QueryParams {
    private Integer productId;

    private Integer productBomId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductBomId() {
        return productBomId;
    }

    public void setProductBomId(Integer productBomId) {
        this.productBomId = productBomId;
    }
}
