package com.deer.wms.produce.manage.service;

import com.deer.wms.produce.manage.model.ProcessBatchRelat;
import com.deer.wms.produce.manage.model.ProcessBatchRelatParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by  on 2019/09/09.
 */
public interface ProcessBatchRelatService extends Service<ProcessBatchRelat, Integer> {


    List<ProcessBatchRelat> findList(ProcessBatchRelatParams  params) ;

}
