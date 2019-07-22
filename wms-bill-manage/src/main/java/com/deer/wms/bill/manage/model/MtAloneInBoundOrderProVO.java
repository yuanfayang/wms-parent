package com.deer.wms.bill.manage.model;

import java.util.List;

public class MtAloneInBoundOrderProVO extends MtAloneInboundOrder{

    private List<MtAloneProduct> proList;

    public List<MtAloneProduct> getProList() {
        return proList;
    }

    public void setProList(List<MtAloneProduct> proList) {
        this.proList = proList;
    }
}
