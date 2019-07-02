package com.deer.wms.bill.manage.model;

import java.util.ArrayList;

public class MtAloneProDetListVO extends MtAloneProduct{

    private ArrayList<MtAloneProductDet> detList=new ArrayList<MtAloneProductDet>();

    public ArrayList<MtAloneProductDet> getDetList() {
        return detList;
    }

    public void setDetList(ArrayList<MtAloneProductDet> detList) {
        this.detList = detList;
    }
}
