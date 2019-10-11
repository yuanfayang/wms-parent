package com.deer.wms.produce.manage.model;

/**
 * 新建加工单时下方展示的材料信息，
 * 涉及mt_alone_materials_info，mt_alone_materials_stock_info，
 * mt_alone_process_bom，mt_alone_process_materials_bom
 * @Author: hy
 * @Date: 2019/10/7 12:25
 * @Version 1.0
 */
public class ProcessMaterialsBomVo extends ProcessMaterialsBom {
    private String processName;//工序名称

    private Integer processStep;//工序步骤

    private String unitName;//单位名称

    private String materialsName;//物料名称

    private Float quantity;//库存数量

    private Float stockDeduct;//库存抵扣数量

    private Float remain;//剩余数量

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Integer getProcessStep() {
        return processStep;
    }

    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getStockDeduct() {
        return stockDeduct;
    }

    public void setStockDeduct(Float stockDeduct) {
        this.stockDeduct = stockDeduct;
    }

    public Float getRemain() {
        return remain;
    }

    public void setRemain(Float remain) {
        this.remain = remain;
    }
}
