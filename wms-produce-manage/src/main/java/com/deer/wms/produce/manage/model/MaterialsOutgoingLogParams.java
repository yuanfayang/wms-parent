package com.deer.wms.produce.manage.model;

import com.deer.wms.produce.manage.constant.ProduceManageConstant;
import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by guo on 2019/07/21.
*/
public class MaterialsOutgoingLogParams extends QueryParams {

    private Integer type = ProduceManageConstant.TYPE_IN;//默认为入库记录

    private Integer materialsId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }
}
