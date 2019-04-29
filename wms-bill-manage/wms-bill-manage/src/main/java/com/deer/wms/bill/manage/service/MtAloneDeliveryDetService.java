package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDetCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryDet;

/**
 * Created by  on 2019/03/07.
 */
public interface MtAloneDeliveryDetService extends Service<MtAloneDeliveryDet, Integer> {


    List<MtAloneDeliveryDet> findList(MtAloneDeliveryDetCriteria  criteria) ;

}
