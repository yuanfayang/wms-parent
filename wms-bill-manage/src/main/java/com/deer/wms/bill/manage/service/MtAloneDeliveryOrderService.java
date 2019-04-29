package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneDeliveryDetParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderCriteria;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderParams;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrderVO;
import com.deer.wms.bill.manage.model.MtAloneProductDetVO;
import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneDeliveryOrder;

/**
 * Created by  on 2018/12/08.
 */
public interface MtAloneDeliveryOrderService extends Service<MtAloneDeliveryOrder, Integer> {


    List<MtAloneDeliveryOrder> findList(MtAloneDeliveryOrderCriteria  criteria) ;

	List<MtAloneDeliveryOrder> findListBykeyAndDate(MtAloneDeliveryOrderCriteria criteria);

	List<MtAloneDeliveryOrder> findDeliveryOrderDetList(MtAloneDeliveryOrderCriteria criteria);

	List<MtAloneProductDetVO> findDetListByOrder(MtAloneDeliveryOrderParams params);

	List<MtAloneDeliveryOrderVO> findListNew(MtAloneDeliveryOrderParams params);

}
