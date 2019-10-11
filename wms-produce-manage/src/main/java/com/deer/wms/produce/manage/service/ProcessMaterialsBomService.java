package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProcessMaterialsBom;
import com.deer.wms.produce.manage.model.ProcessMaterialsBomParams;
import com.deer.wms.produce.manage.model.ProcessMaterialsBomVo;
import com.deer.wms.project.seed.core.service.Service;

import java.util.List;

/**
 * Created by hy on 2019/07/19.
 */
public interface ProcessMaterialsBomService extends Service<ProcessMaterialsBom, Integer> {

    List<ProcessMaterialsBomVo> findProcMatBomVoListByProId(ProcessMaterialsBomParams params);


    //List<ProcessMaterialsBom> findList(ProcessMaterialsBomParams params) ;

}
