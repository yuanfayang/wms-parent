package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/9/5 21:22
 * @Version 1.0
 *
 * 新建生产加工页面对应的结构，集成生产加工单、生产工序、生产物料等信息
 *
 */

public class ProductProcessDto extends ProductProcess {
    private ProcessMaterialsBomVo processMaterialsBomVo;//所有bom信息

    private MtAloneProcess[] mtAloneProcess;//产品工序

    private ProcessMaterials[] processMaterials;//工序所用物料

    private ProductProcessBom productProcessBom;

    private ProcessBom[] processBom;

    private ProcessMaterialsBom[] processMaterialsBom;



    public MtAloneProcess[] getMtAloneProcess() {
        return mtAloneProcess;
    }

    public void setMtAloneProcess(MtAloneProcess[] mtAloneProcess) {
        this.mtAloneProcess = mtAloneProcess;
    }

    public ProcessMaterials[] getProcessMaterials() {
        return processMaterials;
    }

    public void setProcessMaterials(ProcessMaterials[] processMaterials) {
        this.processMaterials = processMaterials;
    }

    public ProductProcessBom getProductProcessBom() {
        return productProcessBom;
    }

    public void setProductProcessBom(ProductProcessBom productProcessBom) {
        this.productProcessBom = productProcessBom;
    }

    public ProcessBom[] getProcessBom() {
        return processBom;
    }

    public void setProcessBom(ProcessBom[] processBom) {
        this.processBom = processBom;
    }

    public ProcessMaterialsBomVo getProcessMaterialsBomVo() {
        return processMaterialsBomVo;
    }

    public void setProcessMaterialsBomVo(ProcessMaterialsBomVo processMaterialsBomVo) {
        this.processMaterialsBomVo = processMaterialsBomVo;
    }
}
