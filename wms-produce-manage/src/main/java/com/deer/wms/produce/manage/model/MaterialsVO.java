package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/7/28 15:52
 * @Version 1.0
 *
 * 包含物料信息和库存信息共同属性的类，用于在一个界面上获取两个对象所有字段信息并存入数据库
 */
public class MaterialsVO {
    private MaterialsInfo materialsInfo;

    private MaterialsStockInfo materialsStockInfo;

    public MaterialsInfo getMaterialsInfo() {
        return materialsInfo;
    }

    public void setMaterialsInfo(MaterialsInfo materialsInfo) {
        this.materialsInfo = materialsInfo;
    }

    public MaterialsStockInfo getMaterialsStockInfo() {
        return materialsStockInfo;
    }

    public void setMaterialsStockInfo(MaterialsStockInfo materialsStockInfo) {
        this.materialsStockInfo = materialsStockInfo;
    }
}
