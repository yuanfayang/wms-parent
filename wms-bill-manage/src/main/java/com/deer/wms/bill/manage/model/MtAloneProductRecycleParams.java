package com.deer.wms.bill.manage.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.ArrayList;
import java.util.List;

/**
* Created by gtt on 2019/08/12.
*/
public class MtAloneProductRecycleParams extends QueryParams {

    List<Integer> proList=new ArrayList<Integer>();

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

    public List<Integer> getProList() {
        return proList;
    }

    public void setProList(List<Integer> proList) {
        this.proList = proList;
    }
}
