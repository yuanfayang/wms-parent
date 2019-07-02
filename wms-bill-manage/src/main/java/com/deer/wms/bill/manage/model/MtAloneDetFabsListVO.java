package com.deer.wms.bill.manage.model;

import java.util.ArrayList;

public class MtAloneDetFabsListVO extends MtAloneProductDet{

    private ArrayList<MtAloneExaminationDetails>fabricList=new ArrayList<MtAloneExaminationDetails>();

    public ArrayList<MtAloneExaminationDetails> getFabricList() {
        return fabricList;
    }

    public void setFabricList(ArrayList<MtAloneExaminationDetails> fabricList) {
        this.fabricList = fabricList;
    }
}
