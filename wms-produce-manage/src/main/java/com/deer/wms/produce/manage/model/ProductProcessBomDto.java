package com.deer.wms.produce.manage.model;

/**
 * @Author: hy
 * @Date: 2019/8/25 13:00
 * @Version 1.0
 */
public class ProductProcessBomDto extends ProductProcessBom{
    private String productName;//产品表里的产品名称

    /**
     * 产品编号
     */
    private String productCode;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 规格型号
     */
    private String specification;
    /**
     * 工序数
     */
    private String processStep;
    /**
     * 加工规格型号
     */
    private String workSpecification;
    /**
     * 加工描述内容
     */
    private String processContent;

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

    @Override
    public String getSpecification() {
        return specification;
    }

    @Override
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProcessStep() {
        return processStep;
    }

    public void setProcessStep(String processStep) {
        this.processStep = processStep;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    public String getWorkSpecification() {
        return workSpecification;
    }

    public void setWorkSpecification(String workSpecification) {
        this.workSpecification = workSpecification;
    }

    @Override
    public String getProcessContent() {
        return processContent;
    }

    @Override
    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }
}
