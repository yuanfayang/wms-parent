package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.List;

public class MtAloneProductDetExamDto extends MtAloneProductDet{

    private List<MtAloneExaminationDetails>detExaminationDetailsList=new ArrayList<MtAloneExaminationDetails>();

    public List<MtAloneExaminationDetails> getDetExaminationDetailsList() {
        return detExaminationDetailsList;
    }

    public void setDetExaminationDetailsList(List<MtAloneExaminationDetails> detExaminationDetailsList) {
        this.detExaminationDetailsList = detExaminationDetailsList;
    }
}
