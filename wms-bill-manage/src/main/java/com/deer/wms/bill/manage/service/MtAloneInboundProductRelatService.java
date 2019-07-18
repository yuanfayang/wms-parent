package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneInboundProductRelat;
import com.deer.wms.bill.manage.model.MtAloneInboundProductRelatParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/07/18.
 */
public interface MtAloneInboundProductRelatService extends Service<MtAloneInboundProductRelat, Integer> {


    List<MtAloneInboundProductRelat> findList(MtAloneInboundProductRelatParams  params) ;

}
