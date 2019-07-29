package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneInBoundOrderProVO extends MtAloneInboundOrder{

    private List<MtAloneProductVO> proList=new ArrayList<MtAloneProductVO>();

    public List<MtAloneProductVO> getProList() { return proList; }

    public void setProList(List<MtAloneProductVO> proList) {
        this.proList = proList;
    }
}
