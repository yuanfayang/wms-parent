package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by  on 2019/10/09.
*/
public class MtAloneMaterialsInfoParams extends QueryParams {
    private String materialName;
    private String materialCode;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
}
