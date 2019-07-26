package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.List;

public class MtAloneColorParams extends QueryParams{
    private Integer colorId;

    private List<String> headersName;

    public List<String> getHeadersName() {
        return headersName;
    }

    public void setHeadersName(List<String> headersName) {
        this.headersName = headersName;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
}
