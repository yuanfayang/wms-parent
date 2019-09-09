package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MachiningProduct;
import com.deer.wms.produce.manage.model.MachiningProductParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface MachiningProductService extends Service<MachiningProduct, Integer> {


    List<MachiningProduct> findList(MachiningProductParams  params) ;

}
