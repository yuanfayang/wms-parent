package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtStockProvendor;
import com.deer.wms.produce.manage.model.MtStockProvendorParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/17.
 */
public interface MtStockProvendorService extends Service<MtStockProvendor, Integer> {


    List<MtStockProvendor> findList(MtStockProvendorParams  params) ;

}
