package com.deer.wms.bill.manage.model;

import java.util.ArrayList;

public class MtAloneDetFabsListVO extends MtAloneProductDet{


    private String productCode;//品号

    private String productName;//产品名称

    private String cellAlias;//货位别名


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCellAlias() {
        return cellAlias;
    }

    public void setCellAlias(String cellAlias) {
        this.cellAlias = cellAlias;
    }

    private ArrayList<MtAloneExaminationDetails>fabricList=new ArrayList<MtAloneExaminationDetails>();

    public ArrayList<MtAloneExaminationDetails> getFabricList() {
        return fabricList;
    }

    public void setFabricList(ArrayList<MtAloneExaminationDetails> fabricList) {
        this.fabricList = fabricList;
    }
}
