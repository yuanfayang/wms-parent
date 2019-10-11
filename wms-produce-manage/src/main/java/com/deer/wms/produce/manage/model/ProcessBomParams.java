package com.deer.wms.produce.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.Date;
import java.util.List;

/**
* Created by guo on 2019/07/18.
*/
public class ProcessBomParams extends QueryParams {
    /**
     * 产品表中的id
     */
    private Integer id;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 产品加工总名称
     */
    private String productProcessName;
    /**
     * 加工规格型号
     */
    private String specification;
    /**
     * 加工描述内容
     */
    private String processContent;
    /**
     * 备注
     */
    private String memo;
    /**
     * 工序步骤
     */
    private Integer processStep;
    /**
     * 工序执行部门
     */
    private String processApartment;
    /**
     * 新增bom的id
     */
    private Integer productProcessId;

    private List<ProcessBomVo> processBomVoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProductProcessName() {
        return productProcessName;
    }

    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProcessContent() {
        return processContent;
    }

    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getProductProcessId() {
        return productProcessId;
    }

    public Integer getProcessStep() {
        return processStep;
    }

    public void setProcessStep(Integer processStep) {
        this.processStep = processStep;
    }

    public String getProcessApartment() {
        return processApartment;
    }

    public void setProcessApartment(String processApartment) {
        this.processApartment = processApartment;
    }

    public void setProductProcessId(Integer productProcessId) {
        this.productProcessId = productProcessId;
    }

    public List<ProcessBomVo> getProcessBomVoList() {
        return processBomVoList;
    }

    public void setProcessBomVoList(List<ProcessBomVo> processBomVoList) {
        this.processBomVoList = processBomVoList;
    }
}
