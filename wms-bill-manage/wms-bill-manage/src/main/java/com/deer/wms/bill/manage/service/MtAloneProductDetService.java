package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.bill.manage.model.MtAloneProductDetCriteria;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;
import com.deer.wms.bill.manage.model.MtAloneProductDet;

/**
 * Created by  on 2019/03/02.
 */
public interface MtAloneProductDetService extends Service<MtAloneProductDet, Integer> {


    List<MtAloneProductDet> findList(MtAloneProductDetCriteria  criteria) ;

}
