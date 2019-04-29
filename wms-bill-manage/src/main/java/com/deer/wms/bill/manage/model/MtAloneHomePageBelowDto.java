package com.deer.wms.bill.manage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 首页面下面统计数量
 */

public class MtAloneHomePageBelowDto extends MtAloneProductDet {

    private ArrayList<Date> arrDateList = new ArrayList<Date>();//入库日期

    private ArrayList<Double> arrMilesList = new ArrayList<Double>();//入库米数

    private ArrayList<Date> delDateList = new ArrayList<Date>();//出库日期

    private ArrayList<Double> delMilesList = new ArrayList<Double>();//出库米数

    public ArrayList<Date> getArrDateList() {
        return arrDateList;
    }

    public void setArrDateList(ArrayList<Date> arrDateList) {
        this.arrDateList = arrDateList;
    }

    public ArrayList<Double> getArrMilesList() {
        return arrMilesList;
    }

    public void setArrMilesList(ArrayList<Double> arrMilesList) {
        this.arrMilesList = arrMilesList;
    }

    public ArrayList<Date> getDelDateList() {
        return delDateList;
    }

    public void setDelDateList(ArrayList<Date> delDateList) {
        this.delDateList = delDateList;
    }

    public ArrayList<Double> getDelMilesList() {
        return delMilesList;
    }

    public void setDelMilesList(ArrayList<Double> delMilesList) {
        this.delMilesList = delMilesList;
    }
}
