package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneProduct;
import com.deer.wms.bill.manage.model.MtAloneProductCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProduct;

/**
 * Created by  on 2019/03/01.
 */
public interface MtAloneProductService extends Service<MtAloneProduct, Integer> {


    List<MtAloneProduct> findList(MtAloneProductCriteria  criteria) ;

}
