package com.deer.wms.detect.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by guotuanting on 2019/08/28.
*/
public class MtAloneSampleClothDetParams extends QueryParams {

    private String begDate;

    private String endDate;

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
