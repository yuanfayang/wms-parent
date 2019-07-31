package com.deer.wms.bill.manage.model;
import java.util.List;

public class MtAloneInboundOrderProDetVO extends MtAloneInboundOrder{

    private String departmentName;

    private List<MtAloneProductDetInboundOrderDto> productDetList;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<MtAloneProductDetInboundOrderDto> getProductDetList() {
        return productDetList;
    }

    public void setProductDetList(List<MtAloneProductDetInboundOrderDto> productDetList) {
        this.productDetList = productDetList;
    }

}
