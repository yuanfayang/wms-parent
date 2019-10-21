package com.deer.wms.produce.manage.model;

/**
 * @Author: 蔡翔
 * @Date: 2019/10/9 13:09
 * @Version 1.0
 */
public class MtAloneProcessMaterialsBomVO extends MtAloneMaterialsInfo {
    /**
     * 操作员id
     */
    private Integer operatorId;

    /**
     * 工序bom 的id
     **/
    private Integer processBomId;

    /**
     *  物料编码
     **/
    private String code;

    /**
     * 规格类型
     **/
    private String specification;

    /**
     * 用量
     **/
    private float dosage;

    /**
     * 单位id
     **/
    private Integer unitId;

    /**
     * 备注
     **/
    private String memo;

    @Override
    public Integer getOperatorId() {
        return operatorId;
    }

    @Override
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getProcessBomId() {
        return processBomId;
    }

    public void setProcessBomId(Integer processBomId) {
        this.processBomId = processBomId;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getSpecification() {
        return specification;
    }

    @Override
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }

    @Override
    public Integer getUnitId() {
        return unitId;
    }

    @Override
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public String getMemo() {
        return memo;
    }

    @Override
    public void setMemo(String memo) {
        this.memo = memo;
    }

}
