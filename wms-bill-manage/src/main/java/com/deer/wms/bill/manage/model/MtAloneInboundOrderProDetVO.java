package com.deer.wms.bill.manage.model;
import java.util.List;

public class MtAloneInboundOrderProDetVO extends MtAloneInboundOrder{

    private List<MtAloneProductDetInboundOrderDto> productDetList;



    public List<MtAloneProductDetInboundOrderDto> getProductDetList() {
        return productDetList;
    }

    public void setProductDetList(List<MtAloneProductDetInboundOrderDto> productDetList) {
        this.productDetList = productDetList;
    }

}
