package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneProcessMethods;
import com.deer.wms.produce.manage.model.MtAloneProcessMethodsParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/16.
 */
public interface MtAloneProcessMethodsService extends Service<MtAloneProcessMethods, Integer> {


    List<MtAloneProcessMethods> findList(MtAloneProcessMethodsParams  params) ;

}
