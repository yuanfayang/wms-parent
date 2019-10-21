package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.MtAloneProcessBom;
import com.deer.wms.produce.manage.model.MtAloneProcessBomParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/10/08.
 */
public interface MtAloneProcessBomService extends Service<MtAloneProcessBom, Integer> {


    List<MtAloneProcessBom> findList(MtAloneProcessBomParams  params) ;

}
