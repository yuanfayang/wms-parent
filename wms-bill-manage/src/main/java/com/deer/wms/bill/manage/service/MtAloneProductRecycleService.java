package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneProductRecycle;
import com.deer.wms.bill.manage.model.MtAloneProductRecycleParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/08/12.
 */
public interface MtAloneProductRecycleService extends Service<MtAloneProductRecycle, Integer> {


    List<MtAloneProductRecycle> findList(MtAloneProductRecycleParams  params) ;

}
