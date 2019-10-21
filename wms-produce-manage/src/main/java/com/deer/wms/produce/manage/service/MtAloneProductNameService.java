package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneProductName;
import com.deer.wms.produce.manage.model.MtAloneProductNameParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/16.
 */
public interface MtAloneProductNameService extends Service<MtAloneProductName, Integer> {


    List<MtAloneProductName> findList(MtAloneProductNameParams  params) ;

}
