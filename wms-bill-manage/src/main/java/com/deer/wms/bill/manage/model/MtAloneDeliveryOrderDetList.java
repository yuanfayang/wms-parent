package com.deer.wms.bill.manage.model;

import java.util.List;

public class MtAloneDeliveryOrderDetList extends MtAloneDeliveryOrder{

    List<MtAloneProductDetVO> deliveryOrderDetVOList;

    public List<MtAloneProductDetVO> getDeliveryOrderDetVOList() {
        return deliveryOrderDetVOList;
    }

    public void setDeliveryOrderDetVOList(List<MtAloneProductDetVO> deliveryOrderDetVOList) { this.deliveryOrderDetVOList = deliveryOrderDetVOList; }
}
