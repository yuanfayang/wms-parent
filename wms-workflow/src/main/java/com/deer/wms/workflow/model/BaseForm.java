package com.deer.wms.workflow.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * BaseForm
 *
 * @author luxin.yan
 * @date 2019/1/29
 **/
public class BaseForm implements Serializable {
    @ApiModelProperty(value = "查询当前页")
    private int currentPage;
    @ApiModelProperty(value = "查询条目数")
    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
