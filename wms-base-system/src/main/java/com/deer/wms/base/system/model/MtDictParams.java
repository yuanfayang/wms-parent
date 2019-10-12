package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by guotuanting on 2019/10/12.
*/
public class MtDictParams extends QueryParams {

    private String dictCodes;

    private Boolean isParent;

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public String getDictCodes() {
        return dictCodes;
    }

    public void setDictCodes(String dictCodes) {
        this.dictCodes = dictCodes;
    }
}
