package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneInBoundOrderProVO extends MtAloneInboundOrder{

    private String departmentName;

    private List<MtAloneProductVO> proList=new ArrayList<MtAloneProductVO>();

    public List<MtAloneProductVO> getProList() { return proList; }

    public void setProList(List<MtAloneProductVO> proList) {
        this.proList = proList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
