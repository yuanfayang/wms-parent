package com.deer.wms.bill.manage.service;

import com.deer.wms.bill.manage.model.MtAloneUserTask;
import com.deer.wms.bill.manage.model.MtAloneUserTaskParams;

import com.deer.wms.project.seed.core.service.Service;
import java.util.List;

/**
 * Created by gtt on 2019/08/11.
 */
public interface MtAloneUserTaskService extends Service<MtAloneUserTask, Integer> {


    List<MtAloneUserTask> findList(MtAloneUserTaskParams  params) ;

}
