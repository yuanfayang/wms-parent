package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProcessDetectRelat;
import com.deer.wms.produce.manage.model.ProcessDetectRelatParams;
import com.deer.wms.project.seed.core.service.Service;

import java.util.List;

/**
 * Created by guo on 2019/07/21.
 */
public interface ProcessDetectRelatService extends Service<ProcessDetectRelat, Integer> {


    List<ProcessDetectRelat> findList(ProcessDetectRelatParams params) ;

}
