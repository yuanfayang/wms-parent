package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBom;
import com.deer.wms.produce.manage.model.MtAloneProcessMaterialsBomParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/08.
 */
public interface MtAloneProcessMaterialsBomService extends Service<MtAloneProcessMaterialsBom, Integer> {


    List<MtAloneProcessMaterialsBom> findList(MtAloneProcessMaterialsBomParams  params) ;

}
