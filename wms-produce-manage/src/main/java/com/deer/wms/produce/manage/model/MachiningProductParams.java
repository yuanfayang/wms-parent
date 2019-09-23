package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;
import io.swagger.models.auth.In;

/**
* Created by  on 2019/09/09.
*/
public class MachiningProductParams extends QueryParams {

    private String productCode;

    private String productName;

    private String specification;


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
