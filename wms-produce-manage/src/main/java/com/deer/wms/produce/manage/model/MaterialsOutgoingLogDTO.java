package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/20 11:23
 * @Version 1.0
 */
public class MaterialsOutgoingLogDTO extends MaterialsOutgoingLog {

    private MaterialsInfo materialsInfo;

    public MaterialsInfo getMaterialsInfo() {
        return materialsInfo;
    }

    public void setMaterialsInfo(MaterialsInfo materialsInfo) {
        this.materialsInfo = materialsInfo;
    }
}
