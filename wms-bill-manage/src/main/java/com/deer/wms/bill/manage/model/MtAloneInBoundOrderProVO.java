package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneInBoundOrderProVO extends MtAloneInboundOrder{

    private List<MtAloneProduct> proList=new ArrayList<MtAloneProduct>();

    public List<MtAloneProduct> getProList() {
        return proList;
    }

    public void setProList(List<MtAloneProduct> proList) {
        this.proList = proList;
    }
}
