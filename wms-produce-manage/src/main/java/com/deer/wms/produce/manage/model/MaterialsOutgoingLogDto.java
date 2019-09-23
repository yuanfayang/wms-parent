package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/20 11:23
 * @Version 1.0
 */
public class MaterialsOutgoingLogDto extends MaterialsOutgoingLog {

    private Integer materialsId;

    private String materialsName;

    private Integer unitId;

    @Override
    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    @Override
    public String getMaterialsName() {
        return materialsName;
    }

    @Override
    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
